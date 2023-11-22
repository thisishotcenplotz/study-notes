package com.bigdata.spark.core.rdd.serialization

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.beans.BeanProperty

object serialization01 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark RDD Serialization")
    val spark = new SparkContext(sparkConf)

    val search = new Search("h")
    val data = Array("hello world", "hello spark", "hive", "flink")
    val rdd = spark.parallelize(data, 2)

//    search.getMatch1(rdd).collect().foreach(println)
    search.getMatch2(rdd).collect().foreach(println)


  }



  class Search(query:String) extends Serializable {

    def isMatch(s:String):Boolean = {
      s.contains(query)
    }

    // 函数序列化案例
    def getMatch1(rdd:RDD[String]):RDD[String] = {
      rdd.filter(isMatch)
    }


    // 属性序列化案列
    def getMatch2(rdd:RDD[String]):RDD[String] = {
      rdd.filter( x => x.contains(this.query))
    }

  }

}
