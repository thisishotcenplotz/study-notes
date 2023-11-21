package com.jiyu.chapter04.whileLoop

import scala.util.control.Breaks.{break, breakable}

object whileBreak {
  def main(args: Array[String]): Unit = {
    var n = 0

    // breakable 是一个高阶函数（可以接收函数的函数）
    breakable{
      while (true) {
        n += 1
        println(n)
        if (n == 18) {

          // 1. 在Scala中使用函数式的break函数来中断循环
          break()
        }
      }
    }

    println("ok")

  }
}
