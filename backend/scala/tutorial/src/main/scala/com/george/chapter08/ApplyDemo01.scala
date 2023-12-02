package com.george.chapter08

object ApplyDemo01 {
  def main(args: Array[String]): Unit = {
    val pig = new Pig("pig")
    println(pig.name)

    val pig1 = Pig.apply()
    println(pig1.name)

  }

  class Pig {
    var name: String = _

    def this(name: String) {
      this
      this.name = name
    }
  }

  object Pig {
    def apply(pName:String):Pig = new Pig(pName)

    def apply():Pig = new Pig("匿名猪")

  }

}
