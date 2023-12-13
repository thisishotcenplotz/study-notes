package com.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SparkSQL01_UDF {
  def main(args: Array[String]): Unit = {

    //TODO 创建SparkSQL的运行环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()


    import spark.implicits._
    //TODO 执行逻辑操作
    val frame = spark.read.json("data/usr.json")
    val user = frame.createOrReplaceTempView("user")
    spark.udf.register("prefixName",(name:String) => {
      "name:" + name
    })
    spark.sql("select age,prefixName(username) as newName from user").show
    spark.sql("select age,prefixName(username) as newName, cast(avg(age) over() as int) as avg_age from user").show




    //TODO 关闭环境
    spark.close()
  }

  case class User(age: Long, username: String)

}
