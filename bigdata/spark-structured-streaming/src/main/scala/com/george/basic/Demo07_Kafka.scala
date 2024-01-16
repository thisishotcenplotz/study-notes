package com.george.basic

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.from_json
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}

object Demo07_Kafka {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("kafka source").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val jsonSchema = new StructType(
      Array(
        StructField("userID",DataTypes.StringType,false),
        StructField("bizdate",DataTypes.TimestampType,false),
        StructField("skuNum",DataTypes.StringType,false),
        StructField("skuQuant",DataTypes.IntegerType,false),
        StructField("itemPrice",DataTypes.DoubleType,false)
      )
    )



    import spark.implicits._
    val kafkaDeltaLake = spark.readStream
      .format("kafka")
      .option("kafka.boot", "")
      .option("kafka.bootstrap.servers", "kafka101:9092,kafka102:9092,kafka:103:9092")
      .option("subscribe", "deltaLake")
      .option("startingOffsets", "earliest")
      .option("kafka.group.id", "deltaGroup")
      .load()

    val jsonValue = kafkaDeltaLake.selectExpr("cast(value as STRING)").as[String]
      .withColumn("value",from_json($"value",jsonSchema))
      .select("value.*")
      .createOrReplaceTempView("theData")

    spark.sql(
      """
        |select
        | date(bizdate) as dt
        | ,skuNum
        | ,sum(skuQuant) as qt
        | ,sum(itemPrice) as total
        |from theData
        |group by date(bizdate),skuNum
        |""".stripMargin)
      .writeStream
      .outputMode("update")
      .format("console")
      .start()
      .awaitTermination()
  }

}
