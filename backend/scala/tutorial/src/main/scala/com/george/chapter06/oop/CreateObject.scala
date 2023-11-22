package com.george.chapter06.oop

object CreateObject {
  def main(args: Array[String]): Unit = {
    val emp = new Employee

    //如果我们希望将子类对象，交给父类引用，这是就需要协商类型
    val emp2:Person = new Employee

  }
}

class Person{

}

class Employee extends Person{

}
