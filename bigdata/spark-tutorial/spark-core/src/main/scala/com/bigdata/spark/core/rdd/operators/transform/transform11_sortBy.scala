package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform11_sortBy {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("sortBy")
    val spark = new SparkContext(conf)

    //TODO  Operator sortBy
    //这个功能主要是缩减分区用的
    val rdd = spark.makeRDD(List(1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,5),2)
    val sortRDD = rdd.sortBy(num => num, ascending = false)
    sortRDD.coalesce(1,shuffle = true).collect().foreach(println)



    spark.stop()
  }

}
