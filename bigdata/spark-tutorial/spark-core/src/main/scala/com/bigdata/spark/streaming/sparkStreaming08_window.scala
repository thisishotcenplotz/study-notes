package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming08_window {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(5))

    val data = streamSpark.socketTextStream("localhost", 9999)

    data.map((_,1))
      .window(Seconds(15),slideDuration = Seconds(15)) //窗口范围应该为采集周期的整数倍
      .reduceByKey(_+_)
      .print()






    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
