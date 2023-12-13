package com.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SparkSQL_Basic {
  def main(args: Array[String]): Unit = {

    //TODO 创建SparkSQL的运行环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    //TODO 执行逻辑操作


    // DataFrame
    val frame = spark.read.json("data/usr.json")

    // DataFrame => SQL
    val user = frame.createTempView("user")
    spark.sql(
      """
        |select
        | username
        | ,age
        | ,row_number() over(order by age desc) as rnk
        |from user
        |order by age desc
        |""".stripMargin).show()

    import spark.implicits._
    // DataFrame => DSL
    frame.select("age", "username").orderBy("age").show()
    frame.select($"age" + 1).alias("newAge").show()


    // TODO DataSet
    val seq = Seq(1, 2, 3, 4)
    seq.toDS().show()

    // RDD <=> DataFrame
    val rdd = spark.sparkContext.parallelize(List((1, "zhangsan", 30), (2, "lisi", 40)))
    val frame1 = rdd.toDF("id", "name", "age")
    frame1.show()
    frame1.rdd.foreach(println)

    // DataFrame <=> DataSet
    val dss = frame.as[User]
    dss.toDF()


    // RDD <=> DataSet
    rdd.map {
      case (id, name, age) => {
        (id, name, age)
      }
    }.toDS().show()



    //TODO 关闭环境
    spark.close()
  }

  case class User(age: Long, username: String)

}
