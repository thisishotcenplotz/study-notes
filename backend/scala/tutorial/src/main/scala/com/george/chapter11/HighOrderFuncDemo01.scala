package com.george.chapter11

object HighOrderFuncDemo01 {
  def main(args: Array[String]): Unit = {
    // High Order Function Usage Example
    val rst = test(sum, 3.5)
    println(rst)

    // 在Scala中可以将一个函数传给一个变量
    val f1 = myPrint _   // 如果不加下划线，则会把myPrint的结果赋值给f1，如果加了下划线则是将myPrint这个函数赋值给f1

    f1.apply() 
  }

  def myPrint(): Unit = {
    println("Hello~ this is My Print")
  }

  // 说明：
  // 1. test 就是一个高阶函数
  // 2. f:Double => Double  表示一个函数，该函数可以接收一个double并返回一个double
  // 3. n1:Double 是一个普通参数
  // 4. f(n1) 代表在test函数中执行传入的函数，当前传入的函数就是f
  def test(f:Double => Double,n1:Double) = {
    println("Function f is processing...")
    f(n1)
  }

  // 普通的函数，接收一个Double，返回一个Double
  def sum(d:Double) = {
    println(s"The SUM function is under process by given real number: ${d}")
    d + d
  }

}
