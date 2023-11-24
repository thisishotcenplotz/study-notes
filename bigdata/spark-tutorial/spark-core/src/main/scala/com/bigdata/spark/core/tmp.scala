package com.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object tmp {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val spark = new SparkContext(conf)

    val data = spark.textFile("data/text1.txt")

    val flatRDD = data.flatMap(_.split(""))
    val tuples = flatRDD.collect()
      .toList
      .sliding(2)
      .map(l => (l(0), l(1))).toList
      .groupBy(_._1)
      .mapValues(t => t.map(f => f._2))
      .map(t => {
        (t._1,t._2.size,t._2)
      })
      .map(t => {
        val k = t._1
        val s = t._2
        val stat = t._3.map((_, 1)).groupBy(_._1).map(k => (k._1, k._2.size))
        (k,s,stat)
      })
      .foreach(println)
  }

}
