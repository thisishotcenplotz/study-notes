package com.george.chapter08

object ChildGameDemo {
  def main(args: Array[String]): Unit = {
    val c1 = new Child("白骨精")
    val c2 = new Child("蜘蛛精")
    val c3 = new Child("老鼠精")
    Child.joinGame(c1)
    Child.joinGame(c2)
    Child.joinGame(c3)
    Child.getCount()
  }

}

class Child {
  var name: String = _

  def this(name: String) {
    this
    this.name = name
  }
}

object Child {
  // 统计共有多少小孩的属性
  var totalChildNum = 0

  def joinGame(child: Child): Unit = {
    println(s"${child.name} joined game")
    totalChildNum += 1
  }

  def getCount(): Unit = {
    println(s"${totalChildNum} children are playing game")
  }
}