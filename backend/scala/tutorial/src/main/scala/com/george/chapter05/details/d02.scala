package com.george.chapter05.details

object d02 {
  def main(args: Array[String]): Unit = {

    println(sum2(1, 2))
    println(sum3(1, "2"))

    //如果写了return 返回值类型不能省略
    def sum(n1:Int,n2:Int):Int = {
      return n1 + n2
    }

    //如果返回值这里什么都没有写，既表示该函数没有返回值
    //这时return无效
    def sum2(n1:Int, n2:Int): Unit = {
      return n1 + n2
    }

    def sum3(n1:Int,n2:String):Any = {
      return n1+n2
    }
  }
}
