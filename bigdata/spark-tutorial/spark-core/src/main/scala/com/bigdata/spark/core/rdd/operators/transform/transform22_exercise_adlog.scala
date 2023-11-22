package com.bigdata.spark.core.rdd.operators.transform

import org.apache.spark.{SparkConf, SparkContext}


object transform22_exercise_adlog {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("ad log")
    val spark = new SparkContext(conf)

    val data = spark.textFile("data/ad.log")
    //    data
    //      .map(_.split(" "))
    //      .map( line => ((line(0).toInt,line(1).toInt),1) )
    //      .reduceByKey(_+_)
    //      .map(line => (line._1._1,(line._1._2,line._2)))
    //      .collect()
    //      .foreach(println)

    // ---------------------------
    val mapRDD = data.map(
      line => {
        val splitData = line.split(" ")
        ((splitData(0), splitData(1)), 1)
      }
    )
    val reduceRDD = mapRDD.reduceByKey(_ + _)

    val newMapRDD = reduceRDD.map {
      case ((province, ad), sum) => (province, (ad, sum))
    }

    val groupRDD = newMapRDD.groupByKey()

    val rstRDD = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(_._2 > _._2).take(3)
      }
    )
    rstRDD.sortBy(_._1.toInt).collect().foreach(println)

  }

}
