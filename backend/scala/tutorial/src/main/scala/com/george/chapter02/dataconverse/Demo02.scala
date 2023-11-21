package com.george.chapter02.dataconverse

object Demo02 {
  def main(args: Array[String]): Unit = {
    val num1:Int = 10*3.5.toInt + 6*1.5.toInt
    val num2:Int = (10*3.5 + 6*1.5).toInt
    println(num1)
    println(num2)
    val char1:Char = 1
    println(char1)

    val num3 = 1
    val char2:Char = num3.toChar
    println(char2)
  }
}
