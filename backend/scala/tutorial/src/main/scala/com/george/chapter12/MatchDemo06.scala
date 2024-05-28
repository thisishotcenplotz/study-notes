package com.george.chapter12

object MatchDemo05 {
  def main(args: Array[String]): Unit = {

    val a = 8
    val obj = if (a == 1) 1
    else if (a == 2) "2"
    else if (a == 3) BigInt(3)
    else if (a == 4) Map("aa" -> 1)
    else if (a == 5) Map(1 -> "aa")
    else if (a == 6) Array(1,2,3)
    else if (a == 7) Array("aa",1)
    else if (a == 8) Array("aa")


    val result = obj match {
      case a: Int => a
      case b: Map[String, Int] => "this is a map"
      case c: Map[Int, String] => "this is another map"
      case d: Array[String] => "this is a Array of String"
      case e: Array[Int] => "this is a Array of Int"
      case f: BigInt => Int.MaxValue
      case _ => "nothing..."
    }
    println(result)
  }
}
