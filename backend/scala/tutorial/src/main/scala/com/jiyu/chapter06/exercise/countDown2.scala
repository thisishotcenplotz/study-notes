package com.jiyu.chapter06.exercise

object countDown2 {
  def main(args: Array[String]): Unit = {
    val str = "Hello"

    println(pow(3.7, 12))


    def pow(x:Double,n:Int):Double = {
      if(n == 0) 1
      else if (n > 0) x * pow(x,n-1)
      else 1 / pow(x,-n)
    }

  }
}
