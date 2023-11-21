package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform02_mapPartition2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 获取每个分区的最大值
    val rdd = spark.makeRDD(List(1, 2, 3, 4,5,6,7,8,9,10),5)
    val rst = rdd.mapPartitions(line => {
      println(">>>>>>>>>")
      List(line.max).iterator
    })
    rst.collect().foreach(println)






    spark.stop()
  }

}