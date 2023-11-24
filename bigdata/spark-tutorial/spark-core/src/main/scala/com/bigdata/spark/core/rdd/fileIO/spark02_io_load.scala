package com.bigdata.spark.core.rdd.fileIO

import org.apache.spark.{SparkConf, SparkContext}

object spark02_io_load {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("io --> load")
    val spark = new SparkContext(sparkConf)

    val rdd1 = spark.textFile("data/text.txt")
    val rdd2 = spark.objectFile[(String, Int)]("output2")
    val rdd3 = spark.sequenceFile[String, Int]("output3")


    spark.stop()
  }

}
