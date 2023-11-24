package com.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

object spark02_acc_example {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("acc example")
    val spark = new SparkContext(sparkConf)

    val rdd = spark.parallelize(List(1, 2, 3, 4))

    // 传统方法
    //    val i = rdd.reduce(_ + _)
    //    println(i)

    // 累加器有 long double collection...
    val sumACC = spark.longAccumulator("sum")
    val rst = rdd.foreach(num =>{
      sumACC.add(num)
    })
    println(s"sum=${sumACC.value}")
    spark.stop()
  }

}
