package com.george.chapter10

object ArrayMulDimDemo01 {
  def main(args: Array[String]): Unit = {
    val array = Array.ofDim[Int](3, 4)
    for(i <- 0 until 3){
      for (j <- 0 until 4){
        print(array(i)(j))
      }
      println()
    }
    for (i <- array){
      for(j <- i){
        print(j)
      }
      println()

    }

  }

}
