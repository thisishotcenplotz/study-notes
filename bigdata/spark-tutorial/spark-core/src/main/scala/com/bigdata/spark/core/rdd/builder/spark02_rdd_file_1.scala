package com.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object spark02_rdd_file_1 {
  def main(args: Array[String]): Unit = {
    //TODO prepare spark environment
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  create rdd
    // create rdd from file
    val filePath:String = "D:\\projects\\java_project\\spark-tutorial\\spark-core\\src\\main\\scala\\com\\bigdata\\spark\\core\\rdd\\builder\\*.txt"
    val dataRDD = spark.wholeTextFiles(filePath)

    dataRDD.collect().foreach(println)
    //TODO close environment
    spark.stop()
  }

}
