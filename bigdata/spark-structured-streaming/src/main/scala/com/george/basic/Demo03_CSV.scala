package com.george.basic

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Demo03_CSV {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[3]").appName("source csv").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    // define schema
    val csvSchema = StructType(Array(
      StructField("id", IntegerType),
      StructField("name", StringType),
      StructField("age", IntegerType)
    ))
    spark.readStream
      .format("csv")
      .option("sep",",")
      .schema(csvSchema)
      .load("data/csv")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }
}
