package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform01_map_par {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator map
    val rdd = spark.makeRDD(List(1, 2, 3, 4),1)
    val mapRDD = rdd.map(num => {
      println(">>>>>" + num)
      num * 10
    })

    val mapRDD1 = mapRDD.map(num => {
      println("+++++" + num)
      num * 10
    })

    mapRDD1.collect()






    spark.stop()
  }

}
