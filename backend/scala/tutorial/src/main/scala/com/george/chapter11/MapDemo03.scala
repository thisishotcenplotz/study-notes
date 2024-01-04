package com.george.chapter11

object MapDemo03 {
  def main(args: Array[String]): Unit = {
    val names = List("George", "Emma", "Daphne")

    names.map(toUpper).foreach(println)
    println("=================================")

    names.map(_.toUpperCase).foreach(println)



  }

  def toUpper(s:String):String = {
    s.toUpperCase
  }

}
