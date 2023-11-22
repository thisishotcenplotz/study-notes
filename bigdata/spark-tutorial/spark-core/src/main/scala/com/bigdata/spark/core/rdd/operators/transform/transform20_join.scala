package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform20_join {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("join")
    val spark = new SparkContext(conf)

    //TODO  Operator join
    val dataLeft = List(("a", 1), ("b", 2), ("c", 3),("d",7))
    val dataRight = List(("a", 4), ("b", 5), ("c", 6),("e",8))

    val rddLeft = spark.parallelize(dataLeft)
    val rddRight = spark.parallelize(dataRight)

    val joinRDD = rddLeft.join(rddRight)
    joinRDD.collect().foreach(println)
    println("--------------------")


    val leftJoinRDD = rddLeft.leftOuterJoin(rddRight)
    leftJoinRDD.collect().foreach(println)
    println("--------------------")



    val rightJoinRDD = rddLeft.rightOuterJoin(rddRight)
    rightJoinRDD.collect().foreach(println)
    println("--------------------")


    val fullJoinRDD = rddLeft.fullOuterJoin(rddRight)
    fullJoinRDD.collect().foreach(println)
  }

}
