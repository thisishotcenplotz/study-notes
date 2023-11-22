package com.george.chapter04.whileLoop

object Demo01 {
  def main(args: Array[String]): Unit = {
    var cnt = 1

    while (cnt <= 10){
      println(s"${cnt} Hello Scala")
      cnt +=1
    }
  }

}
