package com.george.window
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

import java.sql.Timestamp

object demo01 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("window operation demo 01")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    import org.apache.spark.sql.functions._
    val lineData: Dataset[(String, Timestamp)] = spark.readStream.format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .option("includeTimestamp", true)
      .load
      .as[(String, Timestamp)]

    val statResult = lineData
      .flatMap { case (word, ts) => word.split(" ").map((_, ts)) }
      .toDF("word", "ts")
      .groupBy(
        window($"ts", "1 minutes", "1 minutes"),
        $"word"
      ).count()

    statResult
      .writeStream
      .format("console")
      .outputMode("update")
      .queryName("ods level output")
      .trigger(Trigger.Continuous("5 minutes"))
      .option("truncate", false)
      .start()
      .awaitTermination()


  }

}
