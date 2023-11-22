package com.george.chapter07.importDetail

import scala.beans.BeanProperty

// 起别名
import scala.io.{StdIn => opps}


object Demo01 {
  def main(args: Array[String]): Unit = {
    val a:String = opps.readLine()
  }

}

class USR{
  // 下边import的作用域只在当前大括号里
  import scala.beans.BeanProperty
  @BeanProperty var name:String = _
}

class Doggy{
  @BeanProperty var name:String = _
}