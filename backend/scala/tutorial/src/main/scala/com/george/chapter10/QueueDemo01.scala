package com.george.chapter10
import scala.collection.mutable
object QueueDemo01 {
  def main(args: Array[String]): Unit = {
    val queue = new mutable.Queue[Any]()

    queue += 10
    queue ++= List(20,30,40)

    println("-------------------")
    println(queue)
    queue.enqueue(50)
    println(queue)
    queue.dequeue()
    println(queue)
    println(queue.head)
    println(queue)
    println(queue.last)
    println(queue)
    println(queue.tail.tail)
    println(queue)


  }

}
