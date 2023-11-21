package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object transform14_reduceByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("reduceByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator reduceByKey
    val data = List(("a",1),("a",2),("a",3),("a",4),("b",1),("b",2),("b",3),("b",4))
    val rdd = spark.makeRDD(data)

    //相同key的数据进行value的聚合操作
    //scala中一般的聚合都是两两聚合，所以spark也是两两聚合
    rdd.reduceByKey(
      (x:Int,y:Int) => {
        println(s"x = ${x} ; y = ${y}")
        x + y
      }
    ).collect().foreach(println)



    spark.stop()
  }

}
