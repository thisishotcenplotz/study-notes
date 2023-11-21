package com.jiyu.chapter05

object Method2Function {
  def main(args: Array[String]): Unit = {

    //使用方法
    val a = new TheMethod()
    println(a.sum(10, 20))

    //方法转函数
    val f1 = a.sum _
    println(f1(1, 2))

    // 函数
    val f = (n1:Int,n2:Int) => n1+n2
    println(f(3, 4))

  }
}

class TheMethod {
  def sum(n1: Int, n2: Int): Int = {
    return n1 + n2
  }
}
