package com.george.chapter11

object IteratorDemo01 {
  def main(args: Array[String]): Unit = {
    val i1 = (1 to 100).iterator
    while (i1.hasNext){
      println(i1.next())
    }
    println("================")
    
  }

}
