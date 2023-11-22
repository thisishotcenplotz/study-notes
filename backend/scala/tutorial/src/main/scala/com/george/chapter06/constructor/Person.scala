package com.george.chapter06.constructor

class Person {
  var name: String = _
  var age: Int = _

  def this(name:String){
    this
    this.name = name
  }

  def this(name:String, age:Int){
    this
    this.name = name
    this.age = age
  }

  def this(age:Int){
    this
    this.age = age
  }

  def showInfo():Unit = {
    println(s"${this.name}   ${this.age}")
  }

}
