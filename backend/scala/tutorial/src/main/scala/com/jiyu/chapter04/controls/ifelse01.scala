package com.jiyu.chapter04.controls

import scala.io.StdIn

object ifelse01 {
  def main(args: Array[String]): Unit = {
    println("enter your age:")
    val age = StdIn.readInt()
    if( age > 19 ){
      println("age > 19")
    }else{
      println("oops~")
    }
  }

}
