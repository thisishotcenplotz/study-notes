package com.jiyu.chapter04.forLoop

object loopGuard {
  def main(args: Array[String]): Unit = {
    // 循环收尾，既循环保护式（也称为条件判断式，守卫）。保护式为true则进入循环体，为false则跳过

    for (i <- 1 to 10000 if i % 2 == 0) {
      println(i)
    }

    for (i <- 1 to 10000) {
      if (i % 2 == 0) {
        println(i)
      }
    }


  }
}
