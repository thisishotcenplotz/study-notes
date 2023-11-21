package com.bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object spark02_WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("WordCount")

    val spark = new SparkContext(conf)

    val value:RDD[String] = spark.textFile("D:\\projects\\java_project\\spark-tutorial\\spark-core\\wordcount_data.txt")

    val words = value.flatMap(_.split(" "))

    val wordsMap = words.map{ word => (word, 1)}





  }

}
