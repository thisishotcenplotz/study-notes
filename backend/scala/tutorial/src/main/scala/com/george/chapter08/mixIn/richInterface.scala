package com.george.chapter08.mixIn

object richInterface {
  def main(args: Array[String]): Unit = {
    // 富接口：既该特质中既又抽象方法，又有非抽象方法
  }
  trait Operation{
    def insert(id:Int)

    def queryByPage(pageNo:Int,pageSize:Int): Unit = {
      println("分页查询")
    }
  }

}
