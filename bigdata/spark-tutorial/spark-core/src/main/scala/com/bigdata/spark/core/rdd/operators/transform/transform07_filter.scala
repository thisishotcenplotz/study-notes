package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat

object transform07_filter {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("filter")
    val spark = new SparkContext(conf)

    //TODO  Operator filter
    val rdd = spark.parallelize(List(1, 2, 3, 4))
    val filterRDD = rdd.filter(num => num % 2 != 0)
    filterRDD.collect().foreach(println)






    spark.stop()
  }

}
