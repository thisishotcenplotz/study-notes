package com.george.chapter10

import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo01 {
  def main(args: Array[String]): Unit = {
    val value = new ArrayBuffer[Any]()
    value.append(3,4,5)
    value.remove(0)
    value(1) = 8
    for (i <- value){
      println(i)
    }

    value.toArray
    value.toBuffer
  }

}
