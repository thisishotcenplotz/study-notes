package com.george.waterMarking

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.streaming.FileStreamSource.Timestamp
import org.apache.spark.sql.functions.{col, count, window}
import org.apache.spark.sql.types.{StringType, TimestampType}

object windowAndWaterMark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("water mark with window").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    val inputStream = spark.readStream.format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load

    val dataSets = inputStream.as[String].map(
      line => {
        val data = line.split(",")
        (data(0), data(1))
      }
    ).flatMap {
      case (ts, words) => words.split(" ").map((_, ts))
    }.toDF("ts", "word")


    val resultSets = dataSets.withColumn("ts", col("ts").cast(TimestampType))
      .withWatermark("ts", "2 minutes")
      .groupBy(
        window($"ts", "10 minutes", "2 minutes"),
        $"word"
      ).agg(count("*").as("cnt"))

    resultSets.writeStream.format("console")
      .outputMode("update")
      .start()
      .awaitTermination()

  }

}
