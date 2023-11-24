package com.bigdata.spark.core.rdd.persist

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object spark01_rdd_persist {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd persist")
    val spark = new SparkContext(sparkConf)

    val data = List("hello scala", "hello spark")

    val rdd = spark.parallelize(data)

    val flatRDD = rdd.flatMap(_.split(" "))

    val mapRDD = flatRDD.map(word =>{
      println(s"@@@@@@@@@@@@@${word}@@@@@@@@@@@@@@")
      (word,1)
    }).cache()
    // cache() 默认持久化操作只能将数据保存到内存中
    // persist() 可以通过.persist(StorageLevel.DISK_ONLY) 的方法将数据持久化到硬盘中
    // 同时也可以选择多个副本 或者 内存硬盘都做持久化

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
