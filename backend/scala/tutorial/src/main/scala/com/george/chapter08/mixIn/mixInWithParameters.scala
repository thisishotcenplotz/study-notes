package com.george.chapter08.mixIn

object mixInWithParameters {
  def main(args: Array[String]): Unit = {
    val mySQL = new MySQL with DB {}
    println(mySQL.username)
  }

  trait DB{
    var username:String = "localhost"
    def insert(): Unit = {}
  }
  class MySQL{}

}
