package com.bigdata.spark.core.bc

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable


/**
 * 广播变量： 分布式共享只读变量
 * */
object broadcast01 {
  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("broadcast")
    val spark = new SparkContext(sparkConf)

    val rdd1 = spark.parallelize(List(
      ("a", 1), ("b", 2), ("c", 3)
    ))

    val theMap = mutable.Map(("a", 4), ("b", 5), ("c", 6), ("c", 7))

    //    val rdd2 = spark.parallelize(List(
    //      ("a", 4), ("b", 5), ("c", 6),("c", 7)
    //    ))


    // join会导致数据量程几何倍增长，并且会硬性shuffle性能，不推荐使用
    // val joinRDD = rdd1.join(rdd2)
    // joinRDD.collect().foreach(println)   ---> (a,(1,4)) (b,(2,5)) (c,(3,6))

    rdd1.map {
      case (word, count) => {
        val l = theMap.getOrElse(word, 0)
        (word,(count,l))
      }
    }.collect().foreach(println)


    spark.stop()
  }

}
