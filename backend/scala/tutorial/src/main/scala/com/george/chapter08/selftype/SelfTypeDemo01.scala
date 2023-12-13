package com.george.chapter08.selftype

object SelfTypeDemo01 {
  def main(args: Array[String]): Unit = {

  }


  // Logger就是自身类型特质，当这里做了自身类型后
  // 那么就等价于 trait Logger extends Exception, 要求混入该特质的类也是Exception的子类
  trait Logger{

    // 明确告诉编译器，我就是Exception，如果没有这句话，下面的getMessage不能调用
    this: Exception =>
    def log(): Unit = {
      println(getMessage)
    }
  }

//  class Console extends Logger{} // 报错，因为不是Exception的子类
  class Console extends Exception with Logger{} // 这个是对的

}
