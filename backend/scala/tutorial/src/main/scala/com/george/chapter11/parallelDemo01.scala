package com.george.chapter11

object parallelDemo01 {
  def main(args: Array[String]): Unit = {
    val l1 = 1 to 100000000
//    l1.foreach(println)
    println("=========================")
//    l1.par.map(_ * 2).map(_ * 3).foreach(println)


    val rst1 = (0 to 100).map { case _ => Thread.currentThread().getName }.distinct
    val rst2 = (0 to 100).par.map { case _ => Thread.currentThread().getName }.distinct
    println(rst1)
    println(rst2)
  }

}
