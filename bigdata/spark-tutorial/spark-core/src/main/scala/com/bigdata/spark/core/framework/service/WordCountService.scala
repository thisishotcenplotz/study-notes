package com.bigdata.spark.core.framework.service

import com.bigdata.spark.core.framework.common.localService
import com.bigdata.spark.core.framework.dao.WordCountDAO

// 服务层
class WordCountService extends localService{
  private val WordCountDao = new WordCountDAO()

  def dataAnalysis() = {
    val value = WordCountDao.readFile("data/text.txt")

    val words = value.flatMap(_.split(" "))

    val wordGroup = words.groupBy(word => word)

    val wordToCount = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    wordToCount.collect()

  }

}
