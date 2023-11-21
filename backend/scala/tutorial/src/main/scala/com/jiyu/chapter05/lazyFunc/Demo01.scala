package com.jiyu.chapter05.lazyFunc

object Demo01 {
  def main(args: Array[String]): Unit = {
    // lazy 只能修饰val 不能修饰var

    lazy val rst = sum(10, 20)
    println("Hello")
    println("How are you?")
    println("Fine thank you")
    println("And you?")
    println("I am fine too")
    println(rst)

  }

  def sum(n1: Int, n2: Int): Int = {

    println("---------- sum is executing now ----------")
    return n1 + n2
  }

}
