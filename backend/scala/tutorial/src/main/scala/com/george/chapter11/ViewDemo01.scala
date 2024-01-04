package com.george.chapter11

object ViewDemo01 {
  def main(args: Array[String]): Unit = {
    def multi(n:Int):Int = n
    def eq(i:Int):Boolean = i.toString.equals(i.toString.reverse)
    val ls = 1 to 100

    println(ls.map(multi).filter(eq))
    println("======================================")
    println(ls.view.map(multi).filter(eq))
    println("======================================")
    ls.view.map(multi).filter(eq).foreach(println)
  }

}
