package com.george.chapter11

object HighOrderFuncDemo02 {
  def main(args: Array[String]): Unit = {
    test(sayOk)
  }


  // 说明
  // test() 是一个高阶函数，可以接收一个没有输入，返回为Unit的函数
  //
  //
  def test(f: () => Unit) = {
    f()
  }

  def sayOk(): Unit = {
    println("Ok~~~")
  }

}
