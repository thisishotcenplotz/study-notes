package com.jiyu.chapter05.details

object d04 {
  def main(args: Array[String]): Unit = {
    println(sayOK())

  }

  def sayOK(name:String = "jack"): String = {
    return name + " OK"
  }
}
