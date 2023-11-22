package com.george.chapter07.scalapackage{

  package object packageObjectDemo {
    // 可以定义变量和方法

    val name:String = "Scala~~~"

    def sayHi(): Unit = {
      println(name + " saying HI!")
    }
  }

  package packageObjectDemo {


    class Demonstration{

    }

    class LoveScala{

    }

    object TestPKG{
      def main(args: Array[String]): Unit = {
        println(name)
        sayHi()
      }
    }
  }
}
