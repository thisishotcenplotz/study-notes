package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform10_coalesce {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("coalesce")
    val spark = new SparkContext(conf)

    //TODO  Operator coalesce
    //这个功能主要是缩减分区用的
    val rdd = spark.makeRDD(List(1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4),5)
    rdd.coalesce(2,true).collect().foreach(println)




    spark.stop()
  }

}
