package com.george.chapter11

object foldDemo01 {
  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 3, 4, 5)
    println(l.foldLeft(6)(getMin))
  }
  def getMin(n1:Int,n2:Int):Int = {
    if(n1 > n2) n2 else n1
  }

}
