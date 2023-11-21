package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object transform15_groupByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("groupByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator groupByKey
    val data = List(("a",1),("a",2),("a",3),("a",4),("b",1),("b",2),("b",3),("b",4))
    val rdd = spark.makeRDD(data)

    //将数据源中的数据，相同key的数据分在一个组中，形成一个对偶元祖
    //groupByKey需要将数据打乱重组，所以存在shuffle操作

    //shuffle操作必须罗盘处理，不能在内存中数据等待，否则会导致内存溢出；shuffle操作性能要跟磁盘交互所以性能低
    //但是reduceByKey 支持分区内预聚合，可以有效减少shuffle时罗盘数据量，提升整体性能。
    //所以推荐使用reduceByKey
    rdd.groupByKey().foreach(println)

    println("---------------")
    rdd.groupBy(_._1).collect().foreach(println)



    spark.stop()
  }

}
