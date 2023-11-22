package com.george.chapter07.scalapackage{
  package demoPackage{
    class Person{
      val name:String = "Nick"

      def play(message:String):Unit = {
        println((this.name + " " + message))
      }
    }
  }

  package demoPackageExample {
    class Example {
      var name:String = _
      var age:Int = _

      def this(name:String,age:Int){
        this()
        this.name = name
        this.age = age
      }

      def haveFun():Unit = {
        println((this.name + " having fun with somebody"))
      }

    }
  }
}

// Scala支持，在一个文件中，可以同时创建多个包，以及给各个包创建类、trait、object