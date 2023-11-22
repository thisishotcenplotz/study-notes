package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform06_groupBy {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator groupBy

    val rdd = spark.makeRDD(List(1, 2, 3, 4, 5, 6,7,8,9,10), 2)

    def myGroupFunction(num:Int):Int = {
      val g = num % 2
      return g
    }

    rdd.groupBy(myGroupFunction).collect().foreach(println)




    spark.stop()
  }

}
