package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform02_mapPartition {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator mapPartitions
    // 可以以分区为单位进行转换操作。但是会将整个分区的数据加载到内存中进行引用，如果处理完了数据，是不会释放掉的
    // 因为存在数据的引用
    // 那么在数据多，内存小的场合下，容易出现内存溢出
    val rdd = spark.makeRDD(List(1, 2, 3, 4,5,6,7,8,9,10),3)
    val rst = rdd.mapPartitions(line => {
      println(">>>>>>>>>")
      line.map(_ * 2)
    })
    rst.collect().foreach(println)






    spark.stop()
  }

}
