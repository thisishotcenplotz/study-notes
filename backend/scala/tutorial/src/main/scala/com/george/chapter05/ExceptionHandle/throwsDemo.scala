package com.george.chapter05.ExceptionHandle

object throwsDemo {
  def main(args: Array[String]): Unit = {

    try{
      f11()
    }catch {
      case e:Exception => println(e.getMessage)
    }

  }

  @throws(classOf[NumberFormatException])
  def f11(): Unit = {
    "abc".toInt
  }

}
