package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Random

object sparkStreaming02_QueueWordCount {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))




    streamSpark.start()

    streamSpark.awaitTermination()


    // TODO 关闭环境
    // streamingContext.stop()
  }

  // 自定义数据采集器
  // 1. 继承Receiver，定义泛型
  class MyReceiver extends Receiver[String](StorageLevel.MEMORY_ONLY){
    override def onStart(): Unit = {
      new Thread(new Runnable {
        override def run(): Unit = {
          while (true){
            val message = new Random().nextInt(10).toString
            val data = s"当前数据为：${message}"
            Thread.sleep(500)
          }
        }
      }).start()
    }

    override def onStop(): Unit = {

    }
  }

}
