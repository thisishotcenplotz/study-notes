package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action05_save {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action fold")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 1, 3, 4)
    val rdd = spark.parallelize(data,2)

    rdd.saveAsTextFile("myOutput")
    rdd.saveAsObjectFile("myOutput1")

    //saveAsSequenceFile 需要数据为KV类型
    rdd.map(word => (word,1)).saveAsSequenceFile("myOutput2")




    spark.stop()


  }

}
