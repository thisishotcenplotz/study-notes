package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform12_intersection {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("intersection")
    val spark = new SparkContext(conf)

    //TODO  Operator intersection
    val rdd1 = spark.parallelize(List(1, 2, 3, 4))
    val rdd2 = spark.parallelize(List(3, 4, 5, 6))

    //编译不通过;因为2个rdd数据类型不一致（intersection;union;subtract）
//    val rdd2 = spark.parallelize(List("3", "4", "5", "6"))

    rdd2.intersection(rdd1).collect().foreach(println)
    println("-------------------")

    rdd2.union(rdd1).collect().foreach(println)
    println("-------------------")

    rdd2.subtract(rdd1).collect().foreach(println)
    println("-------------------")

    rdd2.zip(rdd1).collect().foreach(println)
    println("-------------------")



    spark.stop()
  }

}
