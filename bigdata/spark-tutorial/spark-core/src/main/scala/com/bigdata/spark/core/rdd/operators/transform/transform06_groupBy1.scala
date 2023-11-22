package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform06_groupBy1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator groupBy
    val rdd = spark.textFile("data/text.txt",2)
    rdd
      .flatMap(_.split(" "))
      .groupBy(_.charAt(0))
      .collect()
      .foreach(println)




    spark.stop()
  }

}
