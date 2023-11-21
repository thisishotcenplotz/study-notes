package com.jiyu.chapter02.datatype

object TypeDemo01 {
  def main(args: Array[String]): Unit = {
    var num1:Int =10

    //在Scala中如果一个方法没有形参则可以省略()
    println(num1.toString)
    sayHi()

    var isPass = true
    println(isPass)
  }

  def sayHi():Unit = {
    println("Say Hi")
  }

}
