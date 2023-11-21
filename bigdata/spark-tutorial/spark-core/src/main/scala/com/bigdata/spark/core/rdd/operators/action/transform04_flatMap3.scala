package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform04_flatMap3 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 获取每个分区的最大值
    val rdd = spark
      .parallelize(
        List(List(1,2,3),4,List(5,6))
      )
    val rdds = rdd.flatMap(
      data => {
        data match {
          case list: List[Int] => list
          case d => List(d)
        }
      }
    )
    rdd.collect().foreach(println)


    spark.stop()
  }

}
