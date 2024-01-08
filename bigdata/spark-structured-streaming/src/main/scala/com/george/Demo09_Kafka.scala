package com.george

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}

object Demo09_Kafka {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("kafka source delta").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val jsonSchema = new StructType()
      .add("userID", DataTypes.StringType)
      .add("bizdate", DataTypes.TimestampType)
      .add("skuNum", DataTypes.StringType)
      .add("skuQuant", DataTypes.IntegerType)
      .add("itemPrice", DataTypes.DoubleType)




    import spark.implicits._
    spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "kafka101:9092,kafka102:9092,kafka:103:9092")
      .option("subscribe", "deltaLake")
      .option("startingOffsets", "earliest")
      .option("kafka.group.id", "deltaGroup")
      .load()
      .selectExpr("topic", "partition", "offset","cast(value as string) as kafkaData")
      .withColumn("kafkaData",from_json($"kafkaData",jsonSchema))
      .select("topic","partition","kafkaData.skuQuant","kafkaData.itemPrice")
      .createOrReplaceTempView("tmp")

    spark.sql(
      """
        |select
        | topic
        | ,partition
        | ,cast( sum(skuQuant)/1000000 as decimal(18,2)) as cnt
        | ,cast( (sum(itemPrice)/1000000) as decimal(18,2)) as amt
        |from tmp
        |group by topic,partition
        |order by partition
        |""".stripMargin)
      .writeStream
      .format("console")
      .outputMode("complete")
      .start()
      .awaitTermination()


  }

}
