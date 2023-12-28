package com.george.chapter09

object ImplicitValueDemo03 {
  def main(args: Array[String]): Unit = {
    implicit val str: String = "jack"
    def hello(implicit name:String): Unit = {
      println(s"Hello ${name}")
    }
    hello
  }

}
// 小结
// 1.当在编译器中，同时有 隐式值 默认值 传值
//   编译器的优先级为 传值 > 隐式值 > 默认值
// 2. 在隐式值匹配时 不能有 二义性
// 3. 如果三个值都没有（隐式值、默认值、传值）就会报错
