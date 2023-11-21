package com.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object spark02_rdd_file {
  def main(args: Array[String]): Unit = {
    //TODO prepare spark environment
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  create rdd
    // create rdd from file
    val filePath:String = "D:\\projects\\java_project\\spark-tutorial\\spark-core\\src\\main\\scala\\com\\bigdata\\spark\\core\\rdd\\builder\\text.txt"
    val dataRDD:RDD[String] = spark.textFile(filePath)
    val result:Array[(String,Int)] = dataRDD
      .flatMap(_.split(" "))
      .map(data => (data, 1))
      .reduceByKey(_ + _)
      .sortBy(_._2,ascending = false)
      .collect()


    result.foreach(println)

    //TODO close environment
    spark.stop()
  }

}
