package com.george.chapter10

object TupleDemo01 {
  def main(args: Array[String]): Unit = {
    // 说明：
    // t1就是tuple，类型是tuple5
    // 为了高效操做元组，编译器根据元素的个数不同，对应不同的元组类型
    // 分别是 Tuple1 --> Tuple22
    //
    //
    //
    val t1 = (1, "2", 3.0, "jack", 'a')
    println(t1)
    println(t1._1)
    println(t1.productElement(3))

    for(i <- t1.productIterator){
      println(i)
    }
     
  }

}
