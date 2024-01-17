package com.george.kafka.dailySales

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DecimalType, IntegerType, StringType, StructType, TimestampType}

object dwdDailySalesKafka {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("read from kafka:deltaLake write to kafka:dailySales").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._
    import org.apache.spark.sql.functions._

    val deltaLakeSchema: StructType = new StructType()
      .add("userID", StringType)
      .add("bizdate", TimestampType)
      .add("skuNum", StringType)
      .add("skuQuant", IntegerType)
      .add("itemPrice", DecimalType(18, 2))

    val kafkaDeltaLakeData = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092")
      .option("subscribe", "deltaLake")
      .load

    kafkaDeltaLakeData
      .withColumn("value",col("value").cast(StringType))
      .withColumn("data",from_json(col("value"),deltaLakeSchema))
      .select(to_json(struct($"data.bizdate",$"data.skuNum",$"data.skuQuant",$"data.itemPrice")))
      .toDF("value")
      .writeStream
      .format("kafka")
      .outputMode("append")
      .option("kafka.bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092")
      .option("topic", "dailySales")
      .option("checkpointLocation","checkPoints/dailySales")
      .start()
      .awaitTermination()


  }

}
