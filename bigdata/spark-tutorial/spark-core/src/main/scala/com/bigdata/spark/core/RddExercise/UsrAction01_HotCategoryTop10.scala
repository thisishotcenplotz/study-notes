package com.bigdata.spark.core.RddExercise

import org.apache.spark.{SparkConf, SparkContext}

object UsrAction01_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Top 10")
    val spark = new SparkContext(conf)


    // 1. 读取原始日志数据
    val rdd = spark.textFile("data/fake_user_visit_action.txt")

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
        catIDs.map(id => (id,1))
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

    // 5. 将品类进行排序，并取前10名
    //    点击数量排序，下单数量排序，支付数量排序
    //    元组排序：先比较第一个，再比较第二个，以此类推。。。
    //    （品类ID，（点击数量，下单数量，支付数量））
    val cogroupRDD = clickCountRDD.cogroup(orderCountRDD, paidCountRDD)

    val resultRDD = cogroupRDD.mapValues {
      case (clickIter, orderIter, paidIter) => {
        var clickCnt = 0
        val iterClick = clickIter.iterator
        if (iterClick.hasNext) {
          clickCnt = iterClick.next()
        }

        var odrCnt = 0
        val iterOdr = orderIter.iterator
        if (iterOdr.hasNext) {
          odrCnt = iterOdr.next()
        }


        var paidCnt = 0
        val iterPaid = paidIter.iterator
        if (iterPaid.hasNext) {
          paidCnt = iterPaid.next()
        }

        (clickCnt, odrCnt, paidCnt)
      }
    }

    val result = resultRDD.sortBy(_._2, false).take(10)

    result.foreach(println)



    spark.stop()
  }

}
