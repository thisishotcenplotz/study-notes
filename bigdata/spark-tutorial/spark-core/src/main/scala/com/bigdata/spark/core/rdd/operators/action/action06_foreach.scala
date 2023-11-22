package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action06_foreach {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action fold")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 1, 3, 4, 5, 6, 7, 8, 9, 10)
    val rdd = spark.parallelize(data, 2)


    // 这里是在driver端内存集合的循环遍历方法
    rdd.collect().foreach(println)
    println("*******************")

    // 这里foreach 是在executor端内存数据打印； 所以显示时候是乱序
    rdd.foreach(println)

    // 算子：Operator
    // RDD的方法和Scala集合对象的方法不一样
    // 集合对象的方法都是在同一个节点的内存中完成的
    // RDD的方法可以将计算逻辑发送到分布式节点执行
    // 为了区分不同的处理效果，所以将RDD的方法称之为算子。
    // RDD的方法外部的操作都是在Driver端执行的，而方法内部的逻辑是在executor端执行的
    //
    //


    spark.stop()


  }

}
