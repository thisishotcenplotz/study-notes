package com.george.chapter05.recursive

object Demo01Exer {
  def main(args: Array[String]): Unit = {
    println(monkey(1))

  }
  private def fibonacci(n:Int):BigInt = {
    if(n == 1 || n ==2){
      1
    }else{
      fibonacci(n-1)+fibonacci(n-1)
    }
  }

  private def getSum(n:Int): BigInt = {
    if(n == 1){
      3
    }else{
      (2*getSum(n-1))+1
    }
  }

  private def monkey(day:Int): Int = {
    if(day == 10){
      1
    }else{
      (monkey(day + 1) + 1) * 2
    }
  }
}
