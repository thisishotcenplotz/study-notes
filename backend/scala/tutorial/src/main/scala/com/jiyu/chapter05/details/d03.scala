package com.jiyu.chapter05.details

object d03 {
  def main(args: Array[String]): Unit = {
    d03.sayOk()
    sayOk()

    def f1(): Unit = {
      println("f1 sayOK")
    }

    def sayOk(): Unit = {
      println("main main sayOK")
      def sayOK(): Unit = {
        println("sayOK sayOK")
      }
    }
  }

  def sayOk(): Unit = {
    println("main sayOK")
  }
}
