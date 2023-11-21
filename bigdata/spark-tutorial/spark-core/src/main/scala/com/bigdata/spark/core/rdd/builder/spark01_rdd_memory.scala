package com.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object spark01_rdd_memory {
  def main(args: Array[String]): Unit = {
    //TODO prepare spark environment
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  create rdd
    // create rdd in memory
    val seq = Seq[Int](1, 2, 3, 4)

    // parallelize : parallelism
    //val dataRDD = spark.parallelize(seq)

    //makeRDD is using parallelize method
    val dataRDD = spark.makeRDD(seq)

    dataRDD
      .collect()
      .foreach(println)

    //TODO close environment
    spark.stop()
  }

}
