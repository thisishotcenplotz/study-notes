package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Duration, Seconds, StreamingContext}

object sparkStreaming01_wordCount {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamingContext = new StreamingContext(conf,Seconds(3))

    // TODO 逻辑处理
    // 获取端口数据
    val lines = streamingContext.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    val wordToOne = words.map(word => (word, 1))
    val wordToCount = wordToOne.reduceByKey(_ + _)
    wordToCount.print()

    streamingContext.start()
    streamingContext.awaitTermination()

    // TODO 关闭环境
    // streamingContext.stop()
  }

}
