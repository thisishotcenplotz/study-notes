package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform16_aggregateByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("aggregateByKey1")
    val spark = new SparkContext(conf)

    //TODO  Operator aggregateByKey1
    val data = List(("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5),("a", 6))
    val rdd = spark.makeRDD(data, 2)
    //aggregateByKey存在函数柯里化，有两个参数列表
    // 第一个参数列表需要传递一个参数，表示为初始值;主要用于碰见第一个key的时候，和value进行分区内计算
    // 第二个参数列表有两个参数，（分区内计算规则，分区间计算规则）

    rdd.aggregateByKey(0)(
      (x, y) => x max y,
      (x, y) => x + y
    ).collect().foreach(println)


    spark.stop()
  }

}
