package com.george.chapter07.abstractdemo

object abstractDetail02 {
  def main(args: Array[String]): Unit = {
    val monster = new Monster {
      override var name: String = _

      override def smile(): Unit = {
        println("Hello Monster")
      }
    }

    monster.smile()

  }

  abstract class Monster {
    var name: String

    def smile()
  }
}
