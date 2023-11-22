package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action03_aggregate {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action reduce")
    val spark = new SparkContext(sparkConf)

    val data = List(1, 2, 3, 4)
    val rdd = spark.parallelize(data)

    // reduce
    val reduceRDD = rdd.reduce(_ + _)
    println(reduceRDD)

    // collect
    // 方法会将不同分区的数据按照分区顺序采集到driver端内存中，形成数组
    val collectRDD = rdd.collect()
    println(collectRDD.mkString(","))

    //count
    println(rdd.count())


    //first
    println(rdd.first())

    //take
    println(rdd.take(3).mkString(","))

    // takeOrdered
    val data1 = List(4,1,3,2)
    val rdd1 = spark.parallelize(data)
    println(rdd1.takeOrdered(3).mkString(","))


    spark.stop()


  }

}
