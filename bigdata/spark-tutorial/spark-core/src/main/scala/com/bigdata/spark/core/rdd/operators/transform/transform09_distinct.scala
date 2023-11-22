package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform09_distinct {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("distinct")
    val spark = new SparkContext(conf)

    //TODO  Operator distinct
    val rdd = spark.makeRDD(List(1,2,3,4,1,2,3,4))
    rdd.distinct().collect().foreach(println)




    spark.stop()
  }

}
