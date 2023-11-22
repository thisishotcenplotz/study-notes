package com.george.chapter01

object TestScala {
  def main(args: Array[String]): Unit = {
    val rst = sum(1,2)
    println(rst)
    println("Hello Scala World!")
  }

  /**
   * @deprecated 过期
   * @example
   *  n1 = 10, n2 = 20 ==> 30
   * @param n1
   * @param n2
   * @return sum of n1 and n2
   *
   * */
  private def sum(n1:Int,n2:Int):Int = {
    return n1 + n2
  }
}
