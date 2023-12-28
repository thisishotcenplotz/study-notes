package com.george.chapter09

object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {


    // 编写一个隐式函数，完成double -> Int 的转换

     implicit def f1(d:Double):Int = {
       d.toInt
     }
    val num:Int = 3.5
    val num2:Int = 6.7
    println(num + num2)
  }

}
