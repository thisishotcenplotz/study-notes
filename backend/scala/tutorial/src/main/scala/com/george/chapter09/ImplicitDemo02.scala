package com.george.chapter09

object ImplicitDemo02 {
  def main(args: Array[String]): Unit = {
    implicit def addDelete(mySQL: MySQL):DB = {
      new DB
    }

    val mySQL = new MySQL
    mySQL.insert()
    mySQL.delete()

  }

  class MySQL {
    def insert(): Unit = {
      println("insert")
    }
  }

  class DB{
    def delete(): Unit = {
      println("delete")
    }
  }

}
