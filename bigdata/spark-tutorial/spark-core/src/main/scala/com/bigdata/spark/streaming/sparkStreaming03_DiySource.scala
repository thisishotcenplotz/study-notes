package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object sparkStreaming03_DiySource {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))
    val rddQueue = new mutable.Queue[RDD[Int]]()

    // TODO 逻辑处理
    val inputStream = streamSpark.queueStream(rddQueue, oneAtATime = false)
    inputStream.map((_,1)).reduceByKey(_+_).print()

    streamSpark.start()
    for (i <- 1 to 10){
      rddQueue += streamSpark.sparkContext.parallelize(1 to 300,10)
      Thread.sleep(2000)
    }

    streamSpark.awaitTermination()


    // TODO 关闭环境
    // streamingContext.stop()
  }

}
