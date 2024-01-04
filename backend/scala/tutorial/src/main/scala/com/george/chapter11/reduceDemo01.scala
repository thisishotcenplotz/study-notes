package com.george.chapter11

object reduceDemo01 {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(l1.reduceLeft(_ + _))
    println(l1.reduceRight(_ + _))
    println(l1.reduceRight(_ + _)) 
  }

}
