package com.george.chapter05.ExceptionHandle

object Demo {
  def main(args: Array[String]): Unit = {
    try {
      val r = 10 / 0
    } catch {
      case e: ArithmeticException => println("捕获了除数为零的算数异常")
      case e: Exception => println("捕获了异常")
    } finally {
      println("scala finally")
    }


  }
}
