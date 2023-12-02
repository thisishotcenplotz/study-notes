package com.george.chapter08.traitExample

object TraitDemo01 {
  def main(args: Array[String]): Unit = {
    val c = new C
    val f = new F
    c.getConnection()
    f.getConnection()
  }

  // 定义一个trait
  trait T01{
    //定义一个规范

    def getConnection()

  }

  class A{

  }

  class B extends A{

  }

  class C extends A with T01 {
    override def getConnection(): Unit = println("MySQL Connected")
  }

  class D{

  }

  class E extends D{

  }

  class F extends D with T01 {
    override def getConnection(): Unit = println("Doris Connected")
  }


}
