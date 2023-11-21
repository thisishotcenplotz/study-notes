package com.jiyu.chapter05.details

object d01 {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger()
    val tiger2 = t01(5,tiger)
    println(tiger.name)
    println(tiger2.name)
    println(tiger.hashCode() + " " + tiger2.hashCode())
    // 这里1 和2 的name是一样的


  }

  def t01(n:Int,t:Tiger):Tiger = {
    println(n)
    t.name = "Tiger"
    println(t.name)
    return t
  }

}

class Tiger{
  var name = ""
}
