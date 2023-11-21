package com.george.chapter02.datatype

object UnitNullNothingDemo {
  def main(args: Array[String]): Unit = {
    val rst = sayHello()
    println(rst)

    val dog: Dog = null
//    val char1:Char = null
    println("ok")
    import scala.math
    val bi = BigInt(2)
      .pow(1024)
      .toString()

    println(bi)
    q()
  }

  //Unit 只有一个实例值 ---> ()
  def sayHello():Unit = {

  }

  def q():Unit = {
    val str = "Hello"

    println(str.take(1))
    println(str.reverse.take(1))
    println(str.takeRight(1))
  }

}

class Dog {

}
