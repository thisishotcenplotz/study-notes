package com.bigdata.spark.core.disCalSim

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor2 {
  def main(args: Array[String]): Unit = {
    val port = 29999
    // Start Server to receive data
    val server = new ServerSocket(port)

    println("Server Started, wait for data")

    // wait for client connection
    val client = server.accept()

    val in = client.getInputStream
    val objIn = new ObjectInputStream(in)
    val task = objIn.readObject().asInstanceOf[SubTask]
    val result = task.compute()


    println(s"Node${port.toString} Task result is: ${result}")

    objIn.close()

    client.close()

    server.close()


  }
}
