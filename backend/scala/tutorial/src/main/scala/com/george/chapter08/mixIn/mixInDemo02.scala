package com.george.chapter08.mixIn

object mixInDemo02 {
  def main(args: Array[String]): Unit = {
    val mySQL = new MySQL with DB with File
    mySQL.insert(666)

  }
  trait Operation{
    def insert(id:Int)
  }
  trait File extends Operation{

    // 说明
    // 1. 如果在子特质中实现了一个父特质的抽象方法，但是同时又调用了super方法
    // 2. 这时我们的方式不是完全实现，因此需要声明为 abstract override
    // 3. 这时 super.insert(id) 的调用就和动态混入的顺序有密切的关系
    abstract override def insert(id: Int): Unit = {
      println("Save data to the file")
      super.insert(id)
    }
  }

  trait DB extends Operation{
    def insert(id: Int): Unit = {
      println(println(s"将数据: ${id}  保存到数据库"))
    }
  }

  class MySQL{}



}
