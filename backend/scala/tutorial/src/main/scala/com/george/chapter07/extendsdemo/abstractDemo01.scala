package com.george.chapter07.extendsdemo

object abstractDemo01 {

  def main(args: Array[String]): Unit = {
    
  }

  abstract class Animal{
    var name:String // 抽象字段
    var age:Int // 抽象字段
    var color:String = "black" // 普通属性

    def cry() //抽象方法
  }

}
