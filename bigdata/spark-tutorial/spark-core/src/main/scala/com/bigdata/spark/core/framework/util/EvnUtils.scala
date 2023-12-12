package com.bigdata.spark.core.framework.util

import org.apache.spark.SparkContext

object EvnUtils {
  private val scLocal = new ThreadLocal[SparkContext]()

  def put(sc:SparkContext): Unit = {
    scLocal.set(sc)
  }

  def take(): Unit = {
    scLocal.get()
  }

  def clear(): Unit = {
    scLocal.remove()
  }

}
