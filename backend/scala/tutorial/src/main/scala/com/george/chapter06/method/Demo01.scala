package com.george.chapter06.method

object Demo01 {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    println(dog.cal(190, 290))
  }

}


class Dog{
  private var salary:Double = _
  var food:Int = _

  def cal(n1:Int,n2:Int):Int = {
    return n1 + n2
  }
}