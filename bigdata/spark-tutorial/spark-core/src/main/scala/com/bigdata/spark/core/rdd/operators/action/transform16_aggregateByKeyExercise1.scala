package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}


object transform16_aggregateByKeyExercise1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("aggregateByKey")
    val spark = new SparkContext(conf)

    //TODO  Operator aggregateByKey
    val data = List(("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5),("a", 6))
    val rdd = spark.makeRDD(data, 2)

    //获取相同key的平均值
    var newRDD = rdd.aggregateByKey((0,0))(
      (t,v) => {(t._1 + v,t._2 + 1)},
      // 1-a:((0,0),1) => ((1,1),2) =>(3,2)
      // 1-b:((0,0),3) => (3,1)

      // 2-a:((0,0),6) => ((6,1))
      // 2-b:((0,0),4) => ((4,1),5) =>(9,2)

      (t1,t2) => {(t1._1 + t2._1, t1._2+t2._2)}
      // a: [(3,2),(6,1)] => (3+6,2+1) => (9,3)
      // b: [(3,1),(9,2)] => (3+9,1+2) => (12,3)
    )
    newRDD.mapValues{
      // a: (9,3) => (9/3) => 3
      // b: (12,3) =>(12/3) => 4
      case (num,cnt) => num / cnt
      // (a,3),(b,4)
    }.collect().foreach(println)


    spark.stop()
  }

}
