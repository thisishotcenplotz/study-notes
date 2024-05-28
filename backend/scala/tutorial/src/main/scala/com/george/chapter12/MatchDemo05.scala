package com.george.chapter12

object MatchDemo04 {
  def main(args: Array[String]): Unit = {
    val ch = "V"
    val rst = ch match {
      case "+" => println("ok")
      case mychar => println(s"ok~~~ ${mychar}")
      case _ => println("ok~~~")
    }
    println(rst)
  }
}
