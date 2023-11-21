package com.jiyu.chapter05.func

object demo01 {
  def main(args: Array[String]): Unit = {
    val n1 = 10
    val n2 = 20
    println(getResult(n1, n2,'*'))
  }

  // define a function
  private def getResult(n1: Int, n2: Int, opr: Char)= {
    if (opr == '+') {
       n1 + n2
    } else if (opr == '-') {
       n1 - n2
    } else {
       null
    }
  }

}
