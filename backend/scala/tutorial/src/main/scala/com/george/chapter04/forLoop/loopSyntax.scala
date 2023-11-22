package com.george.chapter04.forLoop

object loopSyntax {
  def main(args: Array[String]): Unit = {
    //
    //
    //
    for (i <- 1 to 10) {
      for (j <- 1 to 20) {
        print("*")
      }
      println("")
    }

    println("-------------")
    for {
      i<- 1 to 10
    }{
      for {j <- 1 to 20}{
        print("*")
      }
      println("")
    }
  }
}
