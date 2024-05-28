package com.george.chapter12

object MatchDemo02 {
  def main(args: Array[String]): Unit = {
    var oper = '#'
    var n1 = 20
    var n2 = 10
    var res = 0

    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case 1 => println("1 was matched")
      case _ => println("error")
    }

    println("res = " + res)
  }

}
