package com.jiyu.chapter04.forLoop

object loopWithRange {
  def main(args: Array[String]): Unit = {
    //

    for (i <- Range(1, 10, 2)) {
      println(i)
    }
    println("-------------------")
    for(i<- 1 to 10 if i % 2 == 1){
      println(i)
    }

    println("####################")
    for (i <- Range(1, 10, 3)) {
      println(i)
    }
    println("-------------------")
    for (i <- 1 to 10 if i % 3 == 1) {
      println(i)
    }
    "####################"
    for(i <- 1 to 10){
      println(s"${i} ---> ${i % 3}")
    }

    for (i <- 1 to 10 if i % 4 == 1) {
      println(s"${i} ---> ${i % 4}")
    }


  }
}
