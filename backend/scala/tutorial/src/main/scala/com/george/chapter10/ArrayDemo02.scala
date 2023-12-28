package com.george.chapter10

object ArrayDemo02 {
  def main(args: Array[String]): Unit = {
    val array = Array(1, "2", null)
    for (i <- array){
      println(i)
    }
  }

}
