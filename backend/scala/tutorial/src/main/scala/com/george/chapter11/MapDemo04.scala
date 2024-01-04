package com.george.chapter11

object MapDemo04 {
  def main(args: Array[String]): Unit = {
    val names = List("George", "Emma", "Daphne") 

    names.flatMap(_.toUpperCase).foreach(println)
    println("=================================")




  }

  def toUpper(s:String):String = {
    s.toUpperCase
  }

}
