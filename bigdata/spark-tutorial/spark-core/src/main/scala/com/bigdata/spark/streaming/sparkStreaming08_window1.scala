package com.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming08_window1 {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))
    streamSpark.checkpoint("cp")
    val data = streamSpark.socketTextStream("localhost", 9999)


    data.map((_,1))
      .reduceByKeyAndWindow( // 当窗口范围比较大，滑动幅度比较下，可以采用增加数据，删除数据的方式，无需重复计算，来提升性能
        (x:Int,y:Int) => {x + y},
        (x:Int,y:Int) => {x - y},
        Seconds(9),
        Seconds(3)
      ) //窗口范围应该为采集周期的整数倍
      .reduceByKey(_+_)
      .print()






    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
