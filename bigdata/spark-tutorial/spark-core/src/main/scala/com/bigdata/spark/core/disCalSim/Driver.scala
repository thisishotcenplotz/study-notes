package com.bigdata.spark.core.disCalSim

import java.io.ObjectOutputStream
import java.net.Socket


object Driver {
  def main(args: Array[String]): Unit = {
    val port: Int = 19999
    val host: String = "localhost"

    // Connect to the server
    val client1 = new Socket(host, port)
    val client2 = new Socket(host, 29999)

    val task = new Task()

    
    val out1 = client1.getOutputStream
    val outObj1 = new ObjectOutputStream(out1)

    val subTask1 = new SubTask()
    subTask1.logic = task.logic
    subTask1.data = task.data.take(2)

    outObj1.writeObject(subTask1)
    outObj1.flush()
    outObj1.close()
    client1.close()
    //
    val out2 = client2.getOutputStream
    val outObj2 = new ObjectOutputStream(out2)

    val subTask2 = new SubTask()
    subTask2.logic = task.logic
    subTask2.data = task.data.takeRight(2)

    outObj2.writeObject(subTask2)
    outObj2.flush()
    outObj2.close()
    client2.close()


    println("Data send")
  }

}
