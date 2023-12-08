package com.george.chapter08.mixIn


// 混入多个特质的特点（叠加特质）
object addTraits {
  def main(args: Array[String]): Unit = {
    //说明
    // 1. 创建MySQL类实例时，动态混入DB和FIleData

    // 第一个问题：当创建一个动态混入对象时，其顺序是怎样的？
    // 1. Operation。。。
    // 2. data
    // 3. DB
    // 4. File
    // 总结：在叠加特质的时候，首先从后面的特质开始执行（从左到右开始叠加）

    // 第二个问题：当 执行 一个动态混入对象的方法时，其顺序是怎样的？
    // 顺序时，是从右到左开始执行,当执行到super时，是指的左边的特质，如果左边没有特质了，则super就是父特质
    // 1. 向文件
    // 2. 向数据库
    // 3. 向data
    val mySQL = new MySQL with DB with FileData {

    }
    println("----------------------")
    mySQL.insert(100)


  }

  trait Operation {
    println("Operation...")

    def insert(id: Int)
  }

  trait Data extends Operation {
    println("data")

    override def insert(id: Int): Unit = {
      println(s"Insert into data = ${id}")
    }
  }

  trait DB extends Data {
    println("DB")

    override def insert(id: Int): Unit = {
      println("Insert Data to Database.")
      super.insert(id)
    }
  }

  trait FileData extends Data {
    println("File Data")

    override def insert(id: Int): Unit = {
      println("to File Data")
//      super.insert(id) // 这个insert 方法到底是谁的insert跟混入的顺序有密切的关系（难点）
      // 这里的super在动态混入时 不一定是父类

      //如果我们希望直接调用Data的insert方法，可以指定，如下
      // 说明： super[Data] 的类型，必须是当前特质的父特质（超类）
      super[Data].insert(id)
    }
  }

  class MySQL {}


}
