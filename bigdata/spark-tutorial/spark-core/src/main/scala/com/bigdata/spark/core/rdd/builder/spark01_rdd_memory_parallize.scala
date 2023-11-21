package com.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object spark01_rdd_memory_parallize {
  def main(args: Array[String]): Unit = {
    //TODO prepare spark environment
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  create rdd
    // create rdd in memory
    // rdd parallelism and partition
    spark
      .makeRDD(List(1,2,3,4),2)
      .saveAsTextFile("D:\\projects\\java_project\\spark-tutorial\\output")


    //TODO close environment
    spark.stop()
  }

}
