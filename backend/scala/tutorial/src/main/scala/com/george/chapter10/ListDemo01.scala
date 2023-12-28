package com.george.chapter10

object ListDemo01 {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3, 4, 5)
    for (i <- l1) {
      println(i)
    }
    l1.foreach(println)
    val l2 = l1 :+ 6
  }

}
