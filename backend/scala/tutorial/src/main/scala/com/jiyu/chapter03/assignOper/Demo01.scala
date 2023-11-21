package com.jiyu.chapter03.assignOper

object Demo01 {
  def main(args: Array[String]): Unit = {
    var a = (num:Int) => (num<<2)
    var num = 3
    num <<= 2
    println(num)
    println(a(3))

    var left = 10
    var right = 20

    left = left + right
    right = left - right
    left = left - right
    println(left)
    println(right)

  }

}
