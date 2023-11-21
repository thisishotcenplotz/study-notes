package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object transform13_partitionBy {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("partitionBy")
    val spark = new SparkContext(conf)

    //TODO  Operator partitionBy(Key-Value pair)
    // 根据指定的分区规则对数据进行重分区
    val rdd = spark.makeRDD(List(1, 2, 3, 4))
    val mapRDD = rdd.map((_, 1))

    mapRDD.partitionBy(new HashPartitioner(2)).foreach(println)




    spark.stop()
  }

}
