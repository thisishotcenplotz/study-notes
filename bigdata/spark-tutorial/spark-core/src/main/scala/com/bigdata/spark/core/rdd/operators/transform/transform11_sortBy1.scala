package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform11_sortBy1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("sortBy")
    val spark = new SparkContext(conf)

    //TODO  Operator sortBy
    //这个功能主要是缩减分区用的
    // sortBy 默认情况下，不会改变分区，但是中间存在shuffle操作
    val rdd = spark.makeRDD(List(("1",1),("1",1),("2",2),("3",3),("4",4),("5",5)),2)
    rdd.sortBy(t => t._1.toInt,ascending = false).collect().foreach(println)



    spark.stop()
  }

}
