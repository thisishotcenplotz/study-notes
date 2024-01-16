package com.george.basic

import org.apache.spark.sql.SparkSession

object Demo02_Text {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]").appName("text source")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    spark.readStream
      .format("text")
      .load("data")
      .as[String]
      .map(
        line => {
          val str = line.split(" ")
          (str(0), str(1), str(2))
        }
      ).toDF("id", "name", "age")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }
}
