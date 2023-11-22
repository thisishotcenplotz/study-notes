package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform12_intersectionDetail {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("intersection detail")
    val spark = new SparkContext(conf)

    //TODO  Operator intersection


    val rdd1 = spark.parallelize(List(1, 2, 3, 4, 5, 6), numSlices = 2)
    val rdd2 = spark.parallelize(List(3, 4, 5, 6), numSlices = 4)

    // 两个RDD要求分区数量保持一致且元素数量也要保持一致，不然会报错
    rdd2.zip(rdd1).collect().foreach(println)
    println("-------------------")


    spark.stop()
  }

}
