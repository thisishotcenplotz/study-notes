package com.george.chapter11

object MapDemo01 {
  def main(args: Array[String]): Unit = {
    val old = List(1, 2, 3)
    var newList = List[Int]()
    for(i <- old){
//      newList = newList :+ i* 2

      newList :+= i * 2
    }

    println(newList)
    val newList2 = old.map(_ * 2)
    println(newList2)
    newList2
      .map(_ * 2)
      .sortWith(_ > _)
      .foreach(print)

  }
}