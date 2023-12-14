package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming06_Transform {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))
    streamSpark.checkpoint("cp")

    val data = streamSpark.socketTextStream("localhost", 9999)
    val state = data.map((_, 1))
      .updateStateByKey(
        (seq: Seq[Int], buff: Option[Int]) => {
          val newCount = buff.getOrElse(0) + seq.sum
          Option(newCount)
        }
      )
    state.print()



    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
