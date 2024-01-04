package com.tutorial.spark.Spark01Source

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo05_JSON {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("json source").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    val jsonSchema = new StructType()
      .add("id", IntegerType)
      .add("name", StringType)
      .add("age", IntegerType)

    spark.readStream
      .schema(jsonSchema)
      .json("data/jsonFile")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }

}
