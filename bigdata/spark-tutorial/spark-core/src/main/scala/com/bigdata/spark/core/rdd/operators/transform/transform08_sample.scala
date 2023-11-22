package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.helpers.Util

object transform08_sample {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("sample")
    val spark = new SparkContext(conf)

    //TODO  Operator sample
    val rdd = spark.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    // withReplacement: If true then using possion distribution, if false then bernulle distribution
    // fraction: The probability of a individual data that being selected in the data set
    //seed: If the seed is not provided then default using system time
    println(rdd.sample(withReplacement = true, fraction = 0.2)
      .collect().mkString(","))





    spark.stop()
  }

}
