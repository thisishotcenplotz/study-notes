package com.study.joinOperation.examples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DateType, DecimalType, IntegerType, StringType, StructType, TimestampType}

object ods_usr {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[5]").appName("ods_usr").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    import org.apache.spark.sql.functions._
    val odsKafka = spark.readStream.format("kafka")
      .option("kafka.bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092")
      .option("subscribe", "deltaLake")
      .option("startingOffsets","earliest")
      .load
      .select($"value")
      .withColumn("value", col("value").cast(StringType))
      .withColumn("data", from_json(col("value"), new StructType()
        .add("userID", StringType)
        .add("bizdate", TimestampType)
        .add("skuNum", StringType)
        .add("skuQuant", IntegerType)
        .add("itemPrice", DecimalType(15, 2))))
      .select($"data.*")

    val dwsSkuCnt = odsKafka.withWatermark("bizdate", "10 minutes")
      .groupBy(
        col("bizdate").cast(DateType).alias("dt"),
        $"skuNum"
      ).agg(
      sum("skuQuant").alias("skuQuant"),
      max("bizdate").alias("ts")
    )
    // kafka-topics.sh --bootstrap-server kafka101:9092 --create --topic dwsSkuCnt --replication-factor 2 --partitions 5
    // TODO : add stream monitor
    dwsSkuCnt.select(to_json(struct($"dt",$"ts",$"skuNum",$"skuQuant")).alias("value"))
      .writeStream.format("kafka")
      .outputMode("update")
      .option("kafka.bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092")
      .option("topic", "dwsSkuCnt")
      .option("checkpointLocation", "checkPoints/dwsSkuCnt")
      .start()
      .awaitTermination()
  }

}
