package com.george.chapter11

object FilterDemo01 {
  def main(args: Array[String]): Unit = {
    val names = List("George", "Emma", "Daphne")

    names.filter(_.startsWith("G")).foreach(println)





  }

}
