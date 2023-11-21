package com.jiyu.chapter05.func

object FuncPrinciple {
  def main(args: Array[String]): Unit = {
    val n1 = 10
    val n2 = 20

    println(sum(1, 2))
  }

  // define a function
  def sum(n1:Int,n2:Int):Int = {
    return n1 + n2
  }

}
