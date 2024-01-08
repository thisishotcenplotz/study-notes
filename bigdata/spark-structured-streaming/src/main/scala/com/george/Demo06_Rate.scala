package com.george

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo06_Rate {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("rate source").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    spark.readStream
      .format("rate")
      .option("rowsPerSecond",500)
      .option("rampUpTime",0)
      .option("numPartitioons",20)
      .load()
      .writeStream.outputMode("append")
      .format("console")
      .start().awaitTermination()
  }

}
