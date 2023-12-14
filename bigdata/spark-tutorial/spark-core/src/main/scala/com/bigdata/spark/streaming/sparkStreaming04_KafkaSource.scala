package com.bigdata.spark.streaming

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object sparkStreaming04_KafkaSource {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark streaming")
    val streamSpark = new StreamingContext(conf, Seconds(3))

    val kafkaPara:Map[String,Object] = Map[String,Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "stream",
      "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
    )

    val kafkaDataDS = KafkaUtils.createDirectStream[String, String](
      streamSpark,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Set("test"), kafkaPara)
    )
    kafkaDataDS.map(_.value()).print()


    // TODO 逻辑处理


    // TODO 关闭环境
    streamSpark.start()
    streamSpark.awaitTermination()
    // streamingContext.stop()
  }

}
