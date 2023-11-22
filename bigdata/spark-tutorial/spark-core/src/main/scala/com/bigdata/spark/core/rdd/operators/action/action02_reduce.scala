package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action02_reduce {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action aggregate")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 2, 3, 4)
    val rdd = spark.parallelize(data,2)

    //aggregate
    // aggregateByKey的初始值只参与分区内计算
    // aggregate会参与分区内计算,并且还参与分区间计算
    // 40 = 10 + (10 + 1 + 2) + (10 + 3 + 4)
    println(rdd.aggregate(10)(_ + _, _ + _))



    spark.stop()


  }

}
