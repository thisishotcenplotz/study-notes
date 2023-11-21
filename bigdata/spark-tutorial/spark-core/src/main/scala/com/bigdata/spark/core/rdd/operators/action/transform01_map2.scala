package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform01_map2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator map
    val rdd = spark.textFile("data/statement.csv")
    rdd
      .map(line => {
        val data = line.split(",")
        (data(4).split(" ")(0),data(3),BigDecimal(data(6)),BigDecimal(data(7)))
    })
      .collect()
      .foreach(println)




    spark.stop()
  }

}
