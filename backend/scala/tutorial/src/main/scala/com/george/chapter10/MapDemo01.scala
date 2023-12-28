package com.george.chapter10

import scala.collection.mutable

object MapDemo01 {
  def main(args: Array[String]): Unit = {
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "Shenzhen")
    println(map1)

    val map2 = mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "Shenzhen")
    println(map2)

    val map3 = new mutable.HashMap[String, Int]()
    println(map3)

    val map4 = mutable.Map(("A", 1), ("B", 2))
    println(map4("A"))

  }

}
