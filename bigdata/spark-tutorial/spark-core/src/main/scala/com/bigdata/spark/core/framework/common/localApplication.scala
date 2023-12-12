package com.bigdata.spark.core.framework.common

import com.bigdata.spark.core.framework.util.EvnUtils
import org.apache.spark.{SparkConf, SparkContext}

trait localApplication {
  def start(master: String = "local[*]", app: String = "my application")(opr: => Unit): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster(master).setAppName(app)
    val spark = new SparkContext(sparkConf)
    EvnUtils.put(spark)

    try {
      opr
    } catch {
      case ex => println(ex.getMessage)
    }


    spark.stop()
    EvnUtils.clear()
  }

}
