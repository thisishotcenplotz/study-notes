package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming07_join {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(5))

    val data9999 = streamSpark.socketTextStream("localhost", 9999)
    val data8888 = streamSpark.socketTextStream("localhost", 8888)

    val map9 = data9999.map((_, 9))
    val map8 = data8888.map((_, 8))
    val joinData = map9.join(map8)
    joinData.print()





    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
