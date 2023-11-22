package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action04_fold {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action fold")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 1, 3, 4)
    val rdd = spark.parallelize(data,2)

    // fold
    println(rdd.fold(10)(_ + _))

    //countByValue
    val countByKeyRDD = rdd.countByValue()
    println(countByKeyRDD)

    //countByKey
    val data2 = List(("a",1),("a",2),("a",3))
    val rdd2 = spark.parallelize(data2)
    println(rdd2.countByKey())



    spark.stop()


  }

}
