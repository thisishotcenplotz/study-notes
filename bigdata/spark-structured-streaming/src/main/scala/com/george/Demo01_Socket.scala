package com.george

import org.apache.spark.sql.SparkSession

object Demo01_Socket {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("source").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    val df = spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()

    val data = df.as[String].map(
      line => {
        val str = line.split(" ")
        (str(0), str(1), str(2))
      }
    ).toDF("id", "name", "age")

    data.writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()



  }

}
