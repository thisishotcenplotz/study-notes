package com.george.chapter04.forLoop

object loopNested {
  def main(args: Array[String]): Unit = {
    // 没有关键字，所以范围后一定加分号来隔断逻辑
    for (i <- 1 to 10; j <- 1 to 20){
      if(j != 20){
        print("*")
      }else{
        print("*")
        println("")
      }
    }
    println("------------")
    for(i <- 1 to 10){
      for(j <- 1 to 20){
        print("*")
      }
      println("")
    }


  }
}
