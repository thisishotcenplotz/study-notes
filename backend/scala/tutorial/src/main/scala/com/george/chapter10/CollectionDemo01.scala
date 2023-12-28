package com.george.chapter10

object CollectionDemo01 {
  def main(args: Array[String]): Unit = {
    val str = "Hello" // 字符串在scala中就是一个char的集合 IndexSeq
    for (i <- str ){
      println(i)
    }
  }

}
