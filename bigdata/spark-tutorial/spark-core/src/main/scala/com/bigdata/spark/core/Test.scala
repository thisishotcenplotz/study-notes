package com.bigdata.spark.core

import java.sql.{Connection,DriverManager,ResultSet}
object Test {
  def main(args: Array[String]): Unit = {
    val url = ""
    val username = ""
    val password = ""
    val connection = DriverManager.getConnection(url,username,password)

    val statement = connection.createStatement()
    val query = "select * from wlyxls_c.shop_sales_detail limit 20000;"

    val resultSet = statement.executeQuery(query)
    val meta = resultSet.getMetaData()
    val cnt = meta.getColumnCount

    while (resultSet.next()){
      for (i <- 1 to cnt){
        val name = meta.getColumnName(i)
        val value = resultSet.getString(name)
        println(s"${name}:${value}")
      }
      println("----------------------------")
    }

    resultSet.close()
    statement.close()
    connection.close()

  }

}
