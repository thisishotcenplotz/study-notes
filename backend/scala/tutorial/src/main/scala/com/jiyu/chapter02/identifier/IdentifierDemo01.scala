package com.jiyu.chapter02.identifier

object IdentifierDemo01 {
  def main(args: Array[String]): Unit = {
    val ++ = "Hello"
    println(++)
    val -+ = 90
    println(-+)

    val `class`: String = "Class"
    println(`class`)
  }

}
