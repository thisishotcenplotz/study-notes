package com.george.chapter11

object ZipDemo01 {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3)
    val l2 = List("A", "B", "C")
    val t = l1.zip(l2)
    println(t)
  }

}
