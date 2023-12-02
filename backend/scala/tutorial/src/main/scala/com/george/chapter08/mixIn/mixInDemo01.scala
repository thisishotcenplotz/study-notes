package com.george.chapter08.mixIn

object mixInDemo01 {
  def main(args: Array[String]): Unit = {
    //在不修改类的定义基础上，让他们可以使用trait里面的方法
    val oracle = new Oracle with Operate3
    oracle.insert(100)

    val mySQL = new MySQL with Operate3
    mySQL.insert(200)

    val doris = new Doris with Operate3{
      override def sayHi(): Unit = {
        println(s"Hello Doris World")
      }
    }

    doris.insert(300)
    doris.sayHi()

  }

  trait Operate3 {
    def insert(id:Int): Unit = { // 这是一个已经实现了的方法
      println(s"Insert data = ${id}")
    }
  }
  class Oracle{}
  abstract class MySQL{}

  abstract class Doris{
    def sayHi()
  }

}
