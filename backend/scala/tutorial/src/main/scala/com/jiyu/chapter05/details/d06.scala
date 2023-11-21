package com.jiyu.chapter05.details

object d06 {
  def main(args: Array[String]): Unit = {
    println(sum(1, 2, 3, 4, 5, 6, 7,8,9,10))

  }

  def sum(n1: Int, args: Int*): Int = {
    args.sum + n1
  }
}
