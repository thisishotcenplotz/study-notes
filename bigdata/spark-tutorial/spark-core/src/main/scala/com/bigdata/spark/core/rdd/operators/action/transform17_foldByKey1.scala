package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}


object transform17_foldByKey1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("foldByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator foldByKey
    val data = List(("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5),("a", 6))
    val rdd = spark.makeRDD(data, 2)


    // 分区内，分区间规则相同则用foldByKey
    rdd.foldByKey(0)(_+_).sortBy(_._2,ascending = false).collect().foreach(println)

    spark.stop()
  }

}
