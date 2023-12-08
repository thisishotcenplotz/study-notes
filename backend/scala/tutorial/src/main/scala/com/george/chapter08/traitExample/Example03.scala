package com.george.chapter08.traitExample

object Example03{
  def main(args: Array[String]): Unit = {
    // type 可以用来给类型取别名
    type myInt = Int
    val num1:myInt = 888
    println(num1)
    println(Suits.toString())
  }

  object Suits extends Enumeration{
    type Suits = Value
    val A = Value("a")
    val B = Value("b")
    val C = Value("c")
    val D = Value("d")

    override def toString(): String = {
      Suits.values.mkString(",")
    }
  }
}
