package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

object sparkStreaming09_close {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))

    val data = streamSpark.socketTextStream("localhost", 9999)

    data.map((_,1))
      .print()





    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()


    new Thread(
      new Runnable {
        override def run(): Unit = {
          while (true){
            if (true){
              // 读一下MYSQL、REDIS、ZK 等等。。。
              // CODE .....
              // 获取spark状态
              if(streamSpark.getState() == StreamingContextState.ACTIVE) {
              streamSpark.stop(true,true)
              System.exit(0)
              }
            }
          }
        }
      }
    ).start()
  }

}
