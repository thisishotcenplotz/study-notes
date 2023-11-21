package com.george.chapter04.forLoop

object loopVariables {
  def main(args: Array[String]): Unit = {
    // 没有关键字，所以范围后一定加分号来隔断逻辑
    for (i <- -1 to 3; j = 4 - i) {
      println(j)
    }


  }
}
