package com.george.chapter10

import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo02 {
  def main(args: Array[String]): Unit = {
    val array = ArrayBuffer("1", "2", "3", "4")
    import scala.collection.JavaConversions.bufferAsJavaList
    val builder = new ProcessBuilder(array)
    val strings = builder.command()
    println(strings)
    import scala.collection.mutable
    import scala.collection.JavaConversions.asScalaBuffer
    val scalaArray:mutable.Buffer[String] = strings
    scalaArray.append("jack")
    println(scalaArray)
  }

}
