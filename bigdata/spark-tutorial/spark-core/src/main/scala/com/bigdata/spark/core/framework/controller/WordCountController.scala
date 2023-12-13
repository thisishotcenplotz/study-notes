package com.bigdata.spark.core.framework.controller

import com.bigdata.spark.core.framework.common.localController
import com.bigdata.spark.core.framework.service.WordCountService

// 控制层
class WordCountController extends localController{
  private val wordCountService = new WordCountService()

  // 调度
  def dispatch(): Unit = {
    val array = wordCountService.dataAnalysis()
//
//    array.foreach(println)


  }

}
