package com.bigdata.spark.core.rdd.operators.action

import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat

object transform06_groupBy2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("create rdd")
    val spark = new SparkContext(conf)

    //TODO  Operator groupBy
    val rdd = spark.textFile("data/statement.csv")
    rdd
      .map(line =>{
        val dtParser = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss")
        val strings = line.split(",")
//        val dt = dtParser.parse(strings(4).replace("\"",""))


        val dt = strings(4).split(" ")(0).replace("\"","")
        val platform = strings(3)
        val income = BigDecimal(strings(6))
        val outcome = BigDecimal(strings(7))
        (dt,income+outcome)

      })
      .groupBy(_._1)
      .collect()
      .foreach(println)





    spark.stop()
  }

}
