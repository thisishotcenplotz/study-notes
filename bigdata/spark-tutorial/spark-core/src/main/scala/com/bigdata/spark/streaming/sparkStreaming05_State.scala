package com.bigdata.spark.streaming

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming05_State {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))


    val lines = streamSpark.socketTextStream("localhost", 9999)

    // transform可以将底层RDD获取到后进行操作

    val newDS = lines.transform(
      rdd =>{
        // 在Driver端执行（周期性执行）
        rdd.map(
          str => {
            // 此处在executor端执行
            str
          }
        )
      }
    )




    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
