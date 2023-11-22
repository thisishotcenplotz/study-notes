package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform05_glom {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator glom
    val rdd = spark.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    val value = rdd.glom()
    value.collect().foreach(data => println(data.mkString(",")))



    spark.stop()
  }

}
