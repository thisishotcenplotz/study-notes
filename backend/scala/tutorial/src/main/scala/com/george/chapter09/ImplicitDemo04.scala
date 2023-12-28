package com.george.chapter09

object ImplicitDemo04 {
  def main(args: Array[String]): Unit = {
    implicit class DB(m: MySQL) {
      def addPrefix(): String = {
        m + "scala"
      }
    }
    val mySQL = new MySQL
    mySQL.sayOK()
    mySQL.addPrefix()
  }

  class MySQL {
    def sayOK(): Unit = {
      println("OK~~~")
    }
  }

}
