package com.bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object spark03_WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("WordCount")

    val spark = new SparkContext(conf)

    val value:RDD[String] = spark.textFile("data/text.txt")

    wordCount1(spark)
    println("-------------------")
    wordCount2(spark)
    println("-------------------")
    wordCount3(spark)
    println("-------------------")
    wordCount4(spark)
    println("-------------------")
    wordCount5(spark)
    println("-------------------")
    wordCount6(spark)
    println("-------------------")
    wordCount7(spark)
    println("-------------------")
    wordCount8(spark)
    println("-------------------")
    wordCount9(spark)


    def wordCount1(sc:SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .groupBy(word => word)
        .mapValues(iter => iter.size)
        .collect().foreach(println)
    }

    def wordCount2(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .map(word => (word,1))
        .groupByKey()
        .mapValues(iter => iter.size)
        .foreach(println)
    }

    def wordCount3(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .map(word => (word, 1))
        .reduceByKey(_+_)
        .collect()
        .foreach(println)
    }

    def wordCount4(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .map(word => (word, 1))
        .aggregateByKey(0)(_+_,_+_)
        .collect()
        .foreach(println)
    }

    def wordCount5(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .map(word => (word, 1))
        .foldByKey(0)(_+_)
        .collect()
        .foreach(println)
    }

    def wordCount6(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      rdd
        .flatMap(_.split(" "))
        .map(word => (word, 1))
        .combineByKey(v => v,(x:Int,y) => x+y,(x:Int,y:Int) => x + y)
        .collect()
        .foreach(println)
    }

    def wordCount7(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      println(rdd
        .flatMap(_.split(" "))
        .map(word => (word, 1))
        .countByKey())
    }

    def wordCount8(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      println(rdd
        .flatMap(_.split(" "))
        .countByValue())
    }

    def wordCount9(sc: SparkContext): Unit = {
      val rdd = sc.makeRDD(List("hello scala", "hello spark"))
      println(rdd
        .flatMap(_.split(" "))
        .map(word => {
          mutable.Map[String,Long]((word,1))
        })
        .reduce((map1,map2) => {
          map2.foreach{
            case (word,count) =>{
              val newMap = map1.getOrElse(word,0L) + count
              map1.update(word,newMap)
            }
          }
          map1
        })
      )
    }


  }

}
