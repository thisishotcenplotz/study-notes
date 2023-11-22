package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform21_cogroup {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("cogroup")
    val spark = new SparkContext(conf)

    //TODO  Operator cogroup : connect + group
    val dataLeft = List(("a", 1), ("b", 2), ("c", 3))
    val dataRight = List(("a", 4), ("b", 5), ("c", 6), ("c", 6))

    val rddLeft = spark.parallelize(dataLeft)
    val rddRight = spark.parallelize(dataRight)

    val coRdd = rddLeft.cogroup(rddRight)
    coRdd.collect().foreach(println)


  }

}
