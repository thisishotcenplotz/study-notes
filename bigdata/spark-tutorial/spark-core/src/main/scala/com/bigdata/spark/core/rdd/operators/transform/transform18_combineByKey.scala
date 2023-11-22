package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform18_combineByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator combineByKey
    val data = List(("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5),("a", 6))
    val rdd = spark.makeRDD(data, 2)
    // combineByKey:需要三个参数
    //第一个参数：将相同key的第一个数据进行结构转换，实现操作
    //第二个参数：分区内计算规则
    //第三个参数：分区间计算规则
    rdd.combineByKey(
      v =>(v,1),
      (t:(Int,Int),v) =>{
        (t._1+v,t._2+1)
      },
      (t1:(Int,Int),t2:(Int,Int))=>{
        (t1._1 + t2._1,t1._2 + t2._2)
      }
    ).collect().foreach(println)

  }

}
