package com.george.chapter03.input

import scala.io.StdIn

object example {
  def main(args: Array[String]): Unit = {
    //从控制台输入信息
    println("enter your name")
    val name = StdIn.readLine()
//    Dog.sayHi()
//    Dog.sayHello()
    println("enter your age")
    val age = StdIn.readInt()
    println("enter your salary")
    val salary = StdIn.readDouble()
    println(s"name:${name} --> age:${age} --> salary:${salary}")
  }
}


//声明了一个伴生对象
object Dog extends AAA{
  def sayHi():Unit = {
    println("dog: woof woof~")
  }
}


// AAA是特质，等价于Java中的interface + abstract class
trait AAA {
  def sayHello() = {
    println("AAA: Hello")
  }
}