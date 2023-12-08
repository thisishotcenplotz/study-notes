package com.bigdata.spark.core.RddExercise

import org.apache.spark.{SparkConf, SparkContext}

object UsrAction03_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Top 10")
    val spark = new SparkContext(conf)

    // Q: 存在大量的shuffle操作（reduceByKey）
    // reduceByKey 聚合算子，spark会提供优化，缓存


    // 1. 读取原始日志数据
    val rdd = spark.textFile("data/fake_user_visit_action.txt")

    // 2. 将数据转换结构
    //    点击的场合：（品类ID，（1,0,0））
    //    下单的场合：（品类ID，（0,1,0））
    //    支付的场合：（品类ID，（0,0,1））

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

    // 3. 将相同的品类ID的数据进行分组聚合
    //     （品类ID，（点击,下单,支付））

    val resultRDD = flatRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )
    // 4. 将统计结果根据数量进行降序处理，取前10
    val result = resultRDD.sortBy(_._2, false).take(10)

    result.foreach(println)


    spark.stop()
  }

}
