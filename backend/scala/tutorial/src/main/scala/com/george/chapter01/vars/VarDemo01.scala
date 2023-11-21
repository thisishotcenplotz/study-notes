package com.george.chapter01.vars

object VarDemo01 {
  def main(args: Array[String]): Unit = {
    var age:Int = 10
    var salary:Double =10.0
    var name:String = "Tom"
    var isPass:Boolean = true

    // 在Scala中，小数默认为double，整数默认为Int
    var score:Float = 70.9f

    println(s"${age} ${isPass}")


  }

}
