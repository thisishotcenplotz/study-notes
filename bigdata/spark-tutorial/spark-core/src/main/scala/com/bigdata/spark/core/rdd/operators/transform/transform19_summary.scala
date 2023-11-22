package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform19_summary {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator combineByKey
    val data = List(("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5),("a", 6))
    val rdd = spark.makeRDD(data, 2)

    rdd.reduceByKey(_+_) //word count
    rdd.aggregateByKey(0)(_+_,_+_) //word count
    rdd.foldByKey(0)(_+_) //word count
    rdd.combineByKey(v => v, (x:Int,y) => x + y,(x:Int,y:Int) => x + y) //word count



  }

}
