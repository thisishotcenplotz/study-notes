package com.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

object spark03_acc_example {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("acc example")
    val spark = new SparkContext(sparkConf)

    val rdd = spark.parallelize(List(1, 2, 3, 4))

    // 传统方法
    //    val i = rdd.reduce(_ + _)
    //    println(i)
    // ---------------------------------------------------------------------------

    // 累加器有 long double collection...
    //    val sumACC = spark.longAccumulator("sum")
    //    val rst = rdd.map(num =>{
    //      sumACC.add(num)
    //      num
    //    })
    //    println(s"sum=${sumACC.value}")
    // 少加 ===> 打印结果：sum=0 因为map是转换算子。 如果没有行动算子的话，不会执行

    // ---------------------------------------------------------------------------
    val sumACC = spark.longAccumulator("sum")
    val rst = rdd.map(num => {
      sumACC.add(num)
      num
    })
    rst.collect()
    rst.collect()
    println(s"sum=${sumACC.value}")


    // 多加 ===> 打印结果：sum=20 因为collect了两次
    // 一般情况下累加器会放在行动算子中进行操作
    spark.stop()
  }

}
