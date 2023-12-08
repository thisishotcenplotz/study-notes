package com.george.chapter08.traitExample

object TraitDemo02 {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.sayHi()
    dog.sayHello()
  }

  // 定义一个trait
  trait T{
    //抽象方法
    def sayHi()

    //普通方法
    def sayHello(): Unit = {
      println("Hello")
    }
  }

  class Dog extends T{
    override def sayHi(): Unit = println("Hi")
  }


}
