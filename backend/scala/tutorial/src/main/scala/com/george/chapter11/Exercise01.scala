package com.george.chapter11

import scala.collection.mutable.ArrayBuffer

object Exercise01 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBCCCCCCCCCCCCDDDDDDDDDDDDD"
    val rst = sentence.toList
      .map((_, 1))
      .groupBy(_._1)
      .map( kv => (kv._1, kv._2.size) )
      .toList
      .sortWith(_._2 > _._2)

    println(rst)

  }

}
