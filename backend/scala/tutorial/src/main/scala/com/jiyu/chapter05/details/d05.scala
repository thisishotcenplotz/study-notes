package com.jiyu.chapter05.details

object d05 {
  def main(args: Array[String]): Unit = {
    mysqlConnect()
    println("#############")
    mysqlConnect("127.0.0.1", 7777)
    println("#############")
    mysqlConnect(pwd = "123456789")


  }

  private def mysqlConnect(
    add: String = "localhost"
    , port: Int = 3306
    , user: String = "root"
    , pwd: String = "password"
    ): Unit = {
    println(s"add = ${add}")
    println(s"port = ${port}")
    println(s"user = ${user}")
    println(s"pwd = ${pwd}")
  }

}
