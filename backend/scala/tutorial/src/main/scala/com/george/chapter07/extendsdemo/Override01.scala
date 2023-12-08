package com.george.chapter07.extendsdemo

object Override01 {
  //

  def main(args: Array[String]): Unit = {
    val pp = new PP
    pp.printName()


  }
}

class P {
  var name: String = "tom"

  def printName() {
    println(s"P printName() ${this.name}")
  }
}

class PP extends P {
  override def printName(): Unit = {

    println(s"PP printName() ${this.name}")

    // 如果在子类中需要使用父类方法，使用super关键字
    super.printName()
  }
}

