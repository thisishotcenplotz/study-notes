package com.bigdata.spark.core.rdd.fileIO

import org.apache.spark.{SparkConf, SparkContext}

object spark01_io_save {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("io --> save")
    val spark = new SparkContext(sparkConf)

    val rdd = spark.parallelize(
      List(
        ("a", 1),
        ("a", 2),
        ("a", 3),
        ("a", 4),
        ("b", 1),
        ("b", 2),
        ("b", 3),
        ("b", 4)
      )
    )

    rdd.saveAsTextFile("out1")
    rdd.saveAsObjectFile("out2")
    rdd.saveAsSequenceFile("out3")

    spark.stop()
  }

}
