package com.bigdata.spark.core.bc

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable


/**
 * 广播变量： 分布式共享只读变量
 * */
object broadcast02 {
  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("broadcast2")
    val spark = new SparkContext(sparkConf)

    val rdd1 = spark.parallelize(List(
      ("a", 1), ("b", 2), ("c", 3)
    ))


    // 封装广播变量
    val theMap = mutable.Map(("a", 4), ("b", 5), ("c", 6))
    val bc:Broadcast[mutable.Map[String,Int]]= spark.broadcast(theMap)


    rdd1.map {
      case (word, count) => {
        // 访问广播变量
        val l = bc.value.getOrElse(word,0)
        (word,(count,l))
      }
    }.collect().foreach(println)


    spark.stop()
  }

}
