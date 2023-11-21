package com.bigdata.spark.core.disCalSim

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor1 {
  def main(args: Array[String]): Unit = {
    val port = 19999

    // Start Server to receive data
    val server = new ServerSocket(port)

    println("Server Started, wait for data")

    // wait for client connection
    val client = server.accept()

    val in = client.getInputStream
    val objIn = new ObjectInputStream(in)
    val SubTask = objIn.readObject().asInstanceOf[SubTask]
    val result = SubTask.compute()


    println(s"Node${port.toString} Task result is: ${result}")

    objIn.close()

    client.close()

    server.close()


  }
}
