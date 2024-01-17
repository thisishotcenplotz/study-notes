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

    kafkaDeltaLakeData.select($"topic",$"partition",$"offset",$"value")
      .groupBy($"topic",$"partition")
      .agg(
        max("offset").alias("maxOffset"),
        sum("offset").alias("sumOffset")
      )
      .orderBy($"partition".desc)
      .writeStream
      .format("console")
      .outputMode("complete")
      .start()
      .awaitTermination()


"""
      |git remote add origin git@github.com:thisishotcenplotz/tmp.git
      |git branch -M main
      |git push -u origin main
      |
      |git config --global user.name "Your Name"
      |git config --global user.email you@example.com
      |
      |""".stripMargin

  }

}
