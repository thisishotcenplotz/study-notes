package com.george.chapter05.exercise

object triangle {
  def main(args: Array[String]): Unit = {
    printTriangle(11)
  }

  def printTriangle(size: Int): Unit = {

    for (i <- 1 to size) {

      for(j <- 1 to size - i){
        print(" ")
      }

      for(j <- 1 to 2*i -1){
        print("*")
      }

      println("")
    }
  }


  def printTriangle2(size: Int): Unit = {
    for (i <- 1 to size) {

      for (j <- 1 to size - i) {
        print(s"(${i},${j},-)")
      }

      for (j <- 1 to 2 * i - 1) {
        print(s"(${i},${j},*)")
      }

      println("")
    }
  }
}
