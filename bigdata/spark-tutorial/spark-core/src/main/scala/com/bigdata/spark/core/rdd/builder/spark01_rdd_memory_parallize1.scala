package com.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object spark01_rdd_memory_parallize1 {
  def main(args: Array[String]): Unit = {
    //TODO prepare spark environment
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  create rdd
    // create rdd in memory
    // rdd parallelism and partition

    // [1,2],[3,4]
    // [1,3],[2,4]
    // so, how spark deal with partition?

    spark
      .makeRDD(List(1,2,3,4,5),3)
      .collect()
      .foreach(println)


    //TODO close environment
    spark.stop()
  }

}
