package com.george.chapter11

object scanDemo01 {
  def main(args: Array[String]): Unit = {
    println((1 to 10).scanLeft(5)(_ - _))
  }

}
