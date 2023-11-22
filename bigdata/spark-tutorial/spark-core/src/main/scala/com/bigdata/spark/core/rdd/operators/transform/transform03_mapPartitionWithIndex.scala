package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}

object transform03_mapPartitionWithIndex {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 获取每个分区的最大值
    val rdd = spark.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2)
    rdd.mapPartitionsWithIndex(
      (index, iter) => {
        if (index == 1) {
          List(iter.max).iterator
        } else {
//          iter
          Nil.iterator
        }
      }
    )
      .collect()
      .foreach(println)


    spark.stop()
  }

}
