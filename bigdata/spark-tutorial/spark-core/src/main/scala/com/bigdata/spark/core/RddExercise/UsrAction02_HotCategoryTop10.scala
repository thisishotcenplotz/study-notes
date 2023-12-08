package com.bigdata.spark.core.RddExercise

import org.apache.spark.{SparkConf, SparkContext}

object UsrAction02_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Top 10")
    val spark = new SparkContext(conf)

    // Q: rdd 重复使用
    // Q: cogroup 性能可能较低


    // 1. 读取原始日志数据
    val rdd = spark.textFile("data/fake_user_visit_action.txt")
    rdd.cache()

    // 2. 统计品类的点击数量 (品类ID，点击数量)
    val clickActionRDD = rdd.filter(
      action => {
        // 2008-11-04_428798_5107c0f5-2f80-4f65-b5fb-0cc89c231baa_3215_2004-02-29 02:47:18_null_null_null_null_null_10-13-29_10-71-70_264
        val lineData = action.split("_")
        lineData(6) != "null"
      }
    )
    val clickCountRDD = clickActionRDD.map(
      action => {
        val lineData = action.split("_")
        (lineData(6), 1)
      }
    ).reduceByKey(_ + _)


    // 3. 统计品类的下单数量 (品类ID，下单数量)
    val orderActionRDD = rdd.filter(
      action => {
        // 2008-11-04_428798_5107c0f5-2f80-4f65-b5fb-0cc89c231baa_3215_2004-02-29 02:47:18_null_null_null_null_null_10-13-29_10-71-70_264
        val lineData = action.split("_")
        lineData(8) != "null"
      }
    )

    val orderCountRDD = orderActionRDD.flatMap(
      action => {
        val lineData = action.split("_")
        val catIDs = lineData(8).split("-")
        catIDs.map(id => (id, 1))
      }
    ).reduceByKey(_ + _)


    // 4. 统计品类的支付数量 (品类ID，支付数量)

    val paidActionRDD = rdd.filter(
      action => {
        // 2008-11-04_428798_5107c0f5-2f80-4f65-b5fb-0cc89c231baa_3215_2004-02-29 02:47:18_null_null_null_null_null_10-13-29_10-71-70_264
        val lineData = action.split("_")
        lineData(10) != "null"
      }
    )

    val paidCountRDD = paidActionRDD.flatMap(
      action => {
        val lineData = action.split("_")
        val catIDs = lineData(10).split("-")
        catIDs.map(id => (id, 1))
      }
    ).reduceByKey(_ + _)

    val rdd1 = clickCountRDD.map {
      case (cid, cnt) => (cid, (cnt, 0, 0))
    }
    val rdd2 = orderCountRDD.map {
      case (cid, cnt) => (cid, (0, cnt, 0))
    }
    val rdd3 = paidCountRDD.map {
      case (cid, cnt) => (cid, (0, 0, cnt))
    }

    // 将三个rdd合并在一起统一进行聚合计算
    val sourceRDD = rdd1.union(rdd2).union(rdd3)
    val resultRDD = sourceRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )

    val result = resultRDD.sortBy(_._2, false).take(10)

    result.foreach(println)


    spark.stop()
  }

}
