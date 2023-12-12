package com.bigdata.spark.core.framework.application

import com.bigdata.spark.core.framework.common.localApplication
import com.bigdata.spark.core.framework.controller.WordCountController


object WordCountApplication extends App with localApplication {


  start(app = "word count application"){
    val controller = new WordCountController()
    controller.dispatch()
  }
}
