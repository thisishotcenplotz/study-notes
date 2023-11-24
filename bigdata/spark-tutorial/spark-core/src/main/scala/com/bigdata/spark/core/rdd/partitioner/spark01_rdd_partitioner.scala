package com.bigdata.spark.core.rdd.partitioner

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object spark01_rdd_partitioner {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("self define partitioner")
    val spark = new SparkContext(sparkConf)
    val rdd = spark.parallelize(List(
      ("nba", "xxxxxxxxxxxxxxxxxxx"),
      ("cba", "aaaaaaaaaaaaaaaaaaa"),
      ("wba", "bbbbbbbbbbbbbbbbbbb"),
      ("nba", "kkkkkkkkkkkkkkkkkkk")
    ),3)

    val partRDD = rdd.partitionBy(new MyPartitioner)
    partRDD.saveAsTextFile("output")



    spark.stop()
  }
  /**
   * 自定义分区器
   * 1. 继承Partitioner
   * 2. 重写方法
   * */


  class MyPartitioner extends Partitioner {
    // 分区数量
    override def numPartitions: Int = 3

    // 返回数据的key值返回分区索引，从0开始
    override def getPartition(key: Any): Int = {
      key match {
        case "nba" => 0
        case "cba" => 1
        case "wba" => 2
        case _ => 2
      }

    }
  }

}
