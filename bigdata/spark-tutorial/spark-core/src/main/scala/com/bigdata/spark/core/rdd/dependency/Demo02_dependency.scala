package com.bigdata.spark.core.rdd.dependency

import org.apache.spark.{SparkConf, SparkContext}

object Demo02_dependency {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("Spark RDD Dependency Demonstration")

    val spark = new SparkContext(sparkConf)

    val data = spark.textFile("data/text.txt")
    println(data.toDebugString)
    println("**********************")

    val flatMapRDD = data.flatMap(_.split(" "))
    println(flatMapRDD.toDebugString)
    println("**********************")

    val mapRDD = flatMapRDD.map((_, 1))
    println(mapRDD.toDebugString)
    println("**********************")

    val reduceRDD = mapRDD.reduceByKey(_ + _)
    println(reduceRDD.toDebugString)
    println("**********************")

    val sortRDD = reduceRDD.sortBy(t => t._2, ascending = false)
    println(sortRDD.toDebugString)
    println("**********************")
    
    sortRDD.collect().foreach(println)





  }

}
