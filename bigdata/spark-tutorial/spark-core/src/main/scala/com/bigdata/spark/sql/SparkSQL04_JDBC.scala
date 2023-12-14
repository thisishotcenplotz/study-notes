package com.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, SaveMode, SparkSession, functions}


object SparkSQL04_JDBC {
  def main(args: Array[String]): Unit = {

    //TODO 创建SparkSQL的运行环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._
    //TODO 读取MYSQL数据
    val df = spark.read.format("jdbc")
      .option("url", "jdbc:mysql://abc:3306/db1")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "aaa")
      .option("password", "aaa")
      .option("dbtable", "aaa")
      .load()


    df.write.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/test")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "000000")
      .option("dbtable", "aaa")
      .mode(SaveMode.Append)
      .save()






    //TODO 关闭环境
    spark.close()
  }

}
