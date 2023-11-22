package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform04_flatMap2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 获取每个分区的最大值
    val rdd = spark
      .parallelize(
        List("Hello spark", "Hello scala")
      )
    rdd
      .flatMap(s => s.split(" "))
      .map(word => (word,1))
      .reduceByKey(_+_)
      .sortBy(_._2,ascending = false)
      .collect()
      .foreach(println)
//    val rddFlat = rdd.flatMap(
//      s => s.split(" ")
//        .map((_, 1))
//    ).collect().foreach(println)


    spark.stop()
  }

}
