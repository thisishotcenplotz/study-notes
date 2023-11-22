package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform01_map1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator map
    def mapFunction(num: Int): Int = {
      num * 2
    }

    val rdd = spark.makeRDD(List(1, 2, 3, 4))

    val mapRDD = rdd.map(mapFunction)
    mapRDD.collect().foreach(println)

    val mapRDD2 = rdd.map((num:Int) => {num*2})
    mapRDD2.collect().foreach(println)

    val mapRDD3 = rdd.map(_*2)
    mapRDD3.collect().foreach(println)


    spark.stop()
  }

}
