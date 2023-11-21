package com.george.chapter04.whileLoop

import scala.io.StdIn

object Demo03NestedLoop {
  def main(args: Array[String]): Unit = {
    //    example1()
    example2()


  }

  def example1(): Unit = {
    val classNum = 3
    val stuNum = 5
    var score = 0.0
    var classScore = 0.0
    var totalScore = 0.0

    for (i <- 1 to classNum) {

      classScore = 0.0

      for (j <- 1 to stuNum) {
        println(s"enter class ${i} -${j} score")
        score = StdIn.readDouble()
        classScore += score
      }
      println(s"${i} class avg score is ${classScore / stuNum}")
      totalScore += classScore
    }
    println(s"${totalScore / (classNum * stuNum)}")
  }

  def example2() = {
    for (i <- 1 to 9; j <- 1 to i) {
      if (j == i) {
        print(s"${j} * ${i} = ${i * j}\t")
        println("")
      } else {
        print(s"${j} * ${i} = ${i * j}\t")
      }

    }

  }

}
