package com.george.chapter07.abstractdemo

object abstractDetail01 {
  def main(args: Array[String]): Unit = {

    // 默认情况下，一个抽象类是不能实例化的，但是在实例化时动态的实现了抽象类的所有方法也是可以的。
    val animal0 = new Animal00 {
      override def sayHello(): Unit = {
        println("say Hello")
      }
    }
    animal0.sayHello()
  }

  abstract class Animal {
    // 在抽象类中可以有实现的方法
    def sayHi(): Unit = {
      println("XXX")
    }
  }


  abstract class Animal00 {
    def sayHello()
  }

  abstract class Animal000 {
    def sayHello()
    var food: String
  }

  class Cat extends Animal000 {
    var food: String = _
    def sayHello(): Unit = {
      println("Hello")
    }
    def this(food: String) {
      this
      this.food = food
    }
  }
}
