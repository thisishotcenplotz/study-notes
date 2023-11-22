package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform04_flatMap {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 获取每个分区的最大值
    val rdd = spark.parallelize(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))

    rdd
      .flatMap(list => list)
      .collect()
      .foreach(println)


    spark.stop()
  }

}
