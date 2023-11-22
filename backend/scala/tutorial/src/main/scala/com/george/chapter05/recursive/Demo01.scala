package com.george.chapter05.recursive

object Demo01 {
  def main(args: Array[String]): Unit = {
    test2(10)
    test(10)


  }

  private def test(n: Int): Unit = {
    if (n > 2) {
      test(n - 1)
    }
    println(s"n=${n}")
  }

  private def test2(n:Int): Unit = {
    if(n>2){
      test2(n-1)
    }else{
      println(s"n=${n}")
    }
  }
}
