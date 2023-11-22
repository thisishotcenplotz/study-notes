package com.george.chapter06.exercise

object countDown {
  def main(args: Array[String]): Unit = {


    //    printCount(100)

    //    println((1 to 10).reverse)

    //    countDown(100)


    var res = 1L
//    "Hello".foreach(myCount)
    "Hello".foreach( res *= _.toLong)
    println(res)


    def printCount(n:Int):Unit= {
      for(i<- 1 to n reverse){
        println(i)
      }
    }

    def countDown(n:Int):Unit = {
      (0 to n).reverse.foreach(println)
    }

    def myCount(char:Char):Unit = {
      res *= char.toLong
    }




  }

}
