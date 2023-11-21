package com.jiyu.chapter04.controls

import scala.io.StdIn

object ifelse02 {
  def main(args: Array[String]): Unit = {
    val year = 2018
    if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
      s"${year} is true"
    }else {
      println(s"${year} is false")
    }


  }
}
