package com.george.chapter02.dataconverse

object StrToBasic {
  def main(args: Array[String]): Unit = {
    val d1 = 1.2
    val s1 = d1 + ""
    println(s1)
    val s2 = "12"
    val num1 = s2.toInt
    val num2 = s2.toByte
    val num3 = s2.toDouble
    val num4 = s2.toLong

    println(num1)
    println(num2)
    println(num3)
    println(num4)

    val s4 = "12.5"
    println(s4.toDouble.toInt)
  }
}
