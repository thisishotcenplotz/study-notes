package com.jiyu.chapter04.forLoop

object loop {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10){
      println(s"${i}: Hello World")
    }

    val list = List("hello", 10, "tom", 30)
    for(item <- list){
      println(item)
    }

    for (i <- 1 until 3){
      println(i)
    }
  }
}
