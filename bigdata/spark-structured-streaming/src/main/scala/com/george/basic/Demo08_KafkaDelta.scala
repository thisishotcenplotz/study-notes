package com.george.basic

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}

object Demo08_KafkaDelta {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("kafka source delta").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val jsonSchema = new StructType(
      Array(
        StructField("userID", DataTypes.StringType, false),
        StructField("bizdate", DataTypes.TimestampType, false),
        StructField("skuNum", DataTypes.StringType, false),
        StructField("skuQuant", DataTypes.IntegerType, false),
        StructField("itemPrice", DataTypes.DoubleType, false)
      )
    )


    import spark.implicits._
    val kafkaDeltaLake = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "kafka101:9092,kafka102:9092,kafka:103:9092")
      .option("subscribe", "deltaLake")
      .option("startingOffsets", "earliest")
      .option("kafka.group.id", "deltaGroup")
      .load()

    val jsonValue = kafkaDeltaLake.selectExpr("cast(value as STRING)").as[String]
      .withColumn("value", from_json($"value", jsonSchema))
      .select("value.*")
      .createOrReplaceTempView("theData")



    spark.sql(
      """
        |select
        | *
        |from theData
        |""".stripMargin)
      .writeStream
      .outputMode("append")
      .format("console")
      .option("truncate", false)
      .start()
      .awaitTermination()

  }

}
