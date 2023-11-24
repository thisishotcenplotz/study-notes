package com.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

object spark01_acc {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
    val spark = new SparkContext(sparkConf)

    val rdd = spark.parallelize(List(1, 2, 3, 4))

    // 传统方法
    //    val i = rdd.reduce(_ + _)
    //    println(i)

    var sum = 0
    val rst = rdd.foreach(num => sum + num)
    println(s"sum=${sum}")
    spark.stop()
  }

}
