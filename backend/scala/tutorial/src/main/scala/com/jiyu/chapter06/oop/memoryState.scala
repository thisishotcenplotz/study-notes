package com.jiyu.chapter06.oop

object memoryState {
  def main(args: Array[String]): Unit = {
    val h1 = new Human
    h1.name = "Jack"
    h1.age = 10

    val h2 = h1
    h1.name = "Tom"

    println(h1 == h2)
  }
}

class Human {
  var name: String = _
  var age: Int = _
}


