package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

object action07_foreach {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("action fold")
    val spark = new SparkContext(sparkConf)

    val user = new User
    val data = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val rdd = spark.parallelize(data, 2)

    // error: Task not serializable
    // RDD算子中传递的函数是会包含闭包操作，那么就会进行检测
    // 闭包检测
    //
    //
    rdd.foreach( num => println(user.age + num))



    spark.stop()


  }

//  class User extends Serializable {
//    var age:Int = 30
//  }


  // 样例类在编译时，会自动混入序列化特质（实现可序列化接口）
  case class User() {
    var age: Int = 30
  }

}
