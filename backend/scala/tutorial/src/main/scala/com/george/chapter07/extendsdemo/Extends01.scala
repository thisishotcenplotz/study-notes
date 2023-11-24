package com.george.chapter07.extendsdemo

import scala.beans.BeanProperty
object Extends01 {
  def main(args: Array[String]): Unit = {
    val student = new Student
    student.setName("jack")
    student.setAge(30)
    student.showInfo()
    student.studying()
  }
}

class Person {
  @BeanProperty var name: String = _
  @BeanProperty var age: Int = _
  def this(name:String,age:Int){
    this()
    this.name = name
    this.age = age
  }
  def showInfo(): Unit = {
    println(s"name:${this.name} ---> age:${this.age}")
  }
}

class Student extends Person{
  def studying(): Unit = {
    println(s"${this.getName()} is studying scala...")
  }
}

