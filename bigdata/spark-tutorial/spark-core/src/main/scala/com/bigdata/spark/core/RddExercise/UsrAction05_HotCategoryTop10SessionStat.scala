package com.bigdata.spark.core.RddExercise

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object UsrAction05_HotCategoryTop10SessionStat {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Top 10")
    val spark = new SparkContext(conf)


    val rdd = spark.textFile("data/fake_user_visit_action.txt")
    rdd.cache()

    val top10Ids = top10Category(rdd)

    // 1. 过滤原始数据,保留点击和前十品类ID
    val filterActionRDD = rdd.filter(
      action => {
        val lineData = action.split("_")
        if (lineData(6) != "null") {
          top10Ids.contains(lineData(6))
        } else {
          false
        }
      }
    )

    // 2. 根据品类ID和sessionID 进行点击量的统计
    val reduceRDD = filterActionRDD.map(
      action => {
        val lineData = action.split("_")
        ((lineData(6), lineData(2)), 1)
      }
    ).reduceByKey(_+_)



    // 3. 将统计结果进行结构转换
    // ( (品类ID，sessionID),sum ) ==> ( 品类ID，(sessionID,sum) )
    val mapRDD = reduceRDD.map {
      case ((cid, sid), sum) => {
        (cid, (sid, sum))
      }
    }

    // 4. 相同的品类进行分组
    val groupRDD = mapRDD.groupByKey()

    // 5. 将分组后的数据进行点击量排序，取前10
    val resultRDD = groupRDD.mapValues(
      iter => {
        iter.toList.sortBy(_._2)(Ordering.Int.reverse).take(10)
      }
    )
    resultRDD.collect().foreach(println)



    spark.stop()
  }

  def top10Category(rdd: RDD[String])= {
    val flatRDD = rdd.flatMap(
      action => {

        val data = action.split("_")

        if (data(6) != "null") {
          List((data(6), (1, 0, 0)))
        }
        else if (data(8) != "null") {
          val ids = data(8).split("-")
          ids.map(id => (id, (0, 1, 0)))
        }
        else if (data(10) != "null") {
          val ids = data(10).split("-")
          ids.map(id => (id, (0, 0, 1)))
        }
        else {
          Nil
        }
      }
    )
    val resultRDD = flatRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )
    resultRDD.sortBy(_._2, false).take(10).map(_._1)
  }

}
