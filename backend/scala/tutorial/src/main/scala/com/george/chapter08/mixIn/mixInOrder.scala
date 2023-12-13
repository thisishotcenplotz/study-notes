package com.george.chapter08.mixIn

object mixInOrder {
  def main(args: Array[String]): Unit = {
    //    val f1 = new F()
    //    println(f1)
    val f2 = new K with C with D
    println(f2)
  }

  trait A {
    println("A...")
  }

  trait B extends A {
    println("B...")
  }

  trait C extends B {
    println("C...")
  }

  trait D extends B {
    println("D...")
  }

  class E {
    println("E...")
  }

  class F extends E with C with D {
    println("F...")
  }

  class K extends E {
    println("K...")
  }

}
