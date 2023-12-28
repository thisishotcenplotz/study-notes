package com.george.chapter10

object ArrayDemo01 {
  def main(args: Array[String]): Unit = {
    val ints = new Array[Int](4)

    val array = new Array[Any](4)

    for (i <- array){
      println(i)
    }
  }

}
