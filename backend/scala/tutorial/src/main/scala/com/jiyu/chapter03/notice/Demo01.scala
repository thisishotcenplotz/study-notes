package com.jiyu.chapter03.notice

object Demo01 {
  def main(args: Array[String]): Unit = {
    val n1 = 4
    val n2 = 8
    val n3 = 16
    val rst = if(n1 > n2) n1 else n2
    val rstt = n1 max n2 max n3
    println(rst)
    println(rstt)
  }

}
