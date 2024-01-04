package com.george.chapter11

object StreamDemo01 {
  def main(args: Array[String]): Unit = {
    def numForm(n:BigInt):Stream[BigInt] = n #:: numForm(n+1)

    val stream1 = numForm(1)
    println(stream1)
    println(stream1.head)
    println(stream1.tail)
    println(stream1)

    def multi(n:BigInt):BigInt =  n * n

    println(numForm(5).map(multi))
  }

}
