package com.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.connector.expressions.aggregate.UserDefinedAggregateFunc
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}


object SparkSQL02_UDAF {
  def main(args: Array[String]): Unit = {

    //TODO 创建SparkSQL的运行环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    //TODO 执行逻辑操作
    val frame = spark.read.json("data/usr.json")
    val user = frame.createOrReplaceTempView("user")
    spark.udf.register("avgAge", new MyAvgUDAF())
    spark.sql("select username,age,avgAge(age) over() as avg_age from user").show()




    //TODO 关闭环境
    spark.close()
  }

  // 自定义聚合函数类（UDAF）
  class MyAvgUDAF extends UserDefinedAggregateFunction{

    // IN
    override def inputSchema: StructType = {
      StructType(
        Array(StructField("age",LongType))
      )
    }

    // Buffer
    override def bufferSchema: StructType = {
      StructType(
        Array(
          StructField("total", LongType),
          StructField("count", LongType)
        )
      )
    }

    // OUT
    override def dataType: DataType = LongType

    // 函数的稳定性
    override def deterministic: Boolean = true


    // 缓冲区初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
//      buffer(0) = 0L
//      buffer(1) = 0L

      buffer.update(0,0L)
      buffer.update(1,0L)
    }

    //根据输入的值来更新缓冲区数据
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0,buffer.getLong(0)+input.getLong(0))
      buffer.update(1,buffer.getLong(1)+1)
    }

    //缓冲区数据合并
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0,buffer1.getLong(0)+buffer2.getLong(0))
      buffer1.update(1,buffer1.getLong(1)+buffer2.getLong(1))
    }

    // 计算平均值
    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0)/buffer.getLong(1)
    }
  }


}
