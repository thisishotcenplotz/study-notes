package com.jiyu.chapter06.oop

object PropertyDemo {
  def main(args: Array[String]): Unit = {
    val p1 = new Person
  }

}

class Person1{
  var age:Int = 10
  var sal = 8090.9
  var name:String = null
  var address:String = null
}

class A {
  var v1:String = _
}