package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}
object action01_demo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action operator")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 2, 3, 4)
    val rdd = spark.parallelize(data)

    //TODO -行动算子
    // 所谓的行动算子，其实就是出发作业执行的方法
    // 底层代码调用的是环境对象runJob方法
    // 底层代码中会创建ActiveJob，并提交执行
    rdd.collect()


    spark.stop()


  }

}
