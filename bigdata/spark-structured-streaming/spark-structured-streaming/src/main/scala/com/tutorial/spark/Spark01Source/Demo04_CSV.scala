package com.tutorial.spark.Spark01Source

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Demo04_CSV {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[3]").appName("source csv").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    // define schema
    val csvSchema = new StructType()
      .add("id", IntegerType)
      .add("name", StringType)
      .add("age", IntegerType)

    spark.readStream
      .schema(csvSchema)
      .option("sep",",")
      .csv("data/csv")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }

}
