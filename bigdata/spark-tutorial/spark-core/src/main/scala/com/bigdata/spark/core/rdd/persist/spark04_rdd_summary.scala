package com.bigdata.spark.core.rdd.persist

import org.apache.spark.{SparkConf, SparkContext}

object spark04_rdd_summary {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd persist")
    val spark = new SparkContext(sparkConf)
    spark.setCheckpointDir("nowaaa")

    val data = List("hello scala", "hello spark")

    val rdd = spark.parallelize(data)

    val flatRDD = rdd.flatMap(_.split(" "))

    val mapRDD = flatRDD.map(word =>{
      println(s"@@@@@@@@@@@@@${word}@@@@@@@@@@@@@@")
      (word,1)
    })
    mapRDD.checkpoint()

    // checkpoint() 需要落盘，需要指定检查点罗盘路径
    // 一般检查点的保存路径都是在分布式文件存储系统中，比如HDFS

    // ----------------------------------------------------
    val reduceRDD = mapRDD.reduceByKey(_ + _)
    val sortedRDD = reduceRDD.sortBy(_._2, false)
    sortedRDD.collect().foreach(println)
    println("****************************************")
    mapRDD.groupByKey()
      .map(list =>{
        (list._1,list._2.sum)
      })
      .sortBy(_._2,false)
      .collect()
      .foreach(println)
    println("****************************************")


  }
}
