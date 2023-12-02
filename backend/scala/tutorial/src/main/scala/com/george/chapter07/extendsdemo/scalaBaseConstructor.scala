package com.george.chapter07.extendsdemo

object scalaBaseConstructor {
  def main(args: Array[String]): Unit = {
    val emp = new Emp("Lisi")
    println(emp.name)

  }



  class Person{
    var name = "zhangsan"
    println("person...")
  }

  class Emp extends Person{
    println("Emp ...")
    def this(name:String){
      this
      this.name = name
      println("Emp 辅助构造器~")
    }
  }

}
