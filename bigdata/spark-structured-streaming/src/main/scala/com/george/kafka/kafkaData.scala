package com.george.kafka
import io.delta._
import org.apache.spark.sql.SparkSession

object kafkaData {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("read json data from kafka").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    import org.apache.spark.sql.functions._
    val kafkaDeltaLakeData = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092")
      .option("subscribe", "deltaLake")
      .load

    kafkaDeltaLakeData.printSchema()

    kafkaDeltaLakeData.select($"topic",$"partition",$"offset",$"value",$"timestamp")
      .withWatermark("timestamp","10 minutes")
      .groupBy($"topic",$"partition")
      .agg(
        max("offset").alias("maxOffset"),
        sum("offset").alias("sumOffset")
      )
      .writeStream
      .format("console")
      .outputMode("update")
      .start()
      .awaitTermination()


  }

}
