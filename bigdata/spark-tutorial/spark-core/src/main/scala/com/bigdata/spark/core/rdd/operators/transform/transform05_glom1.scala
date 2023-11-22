package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform05_glom1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator glom
    // 求每个分区最大值，然后求和所有最大值

    val rdd = spark.makeRDD(List(1, 2, 3, 4, 5, 6,7,8,9,10), 2)
    val glomRDD = rdd.glom()
    val result = glomRDD
      .map(arr => arr.max)
      .collect()
      .sum
    println(result)




    spark.stop()
  }

}
