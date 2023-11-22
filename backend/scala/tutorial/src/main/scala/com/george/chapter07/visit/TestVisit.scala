package com.george.chapter07.visit

import com.george.chapter07.visit.Human.sayHi

object TestVisit {
  def main(args: Array[String]): Unit = {
    val c = new Clerk
//    println(c.age)
    c.showInfo()
    Clerk.test(c)

    val h = new Human
    sayHi(h)
    println(h.name)
  }
}

// 类
class Clerk {
  var name: String = "Jack"
  private var sal: Double = 9999.9
  protected var age:Int = 10

  def showInfo(): Unit = {
    println(("name=" + name + " salary=" + sal))
  }
}


// 当一个文件中出现了 class Clerk 和 object Clerk
// 1. class Clerk 称为伴生类
// 2. object Clerk 为伴生对象
// 3. 因为Scala设计者将static拿掉了，他就设计了一个伴生类和伴生对象的概念
// 4. 将非静态部分放在伴生类里，静态的放在伴生对象里
object Clerk{
  def test(c:Clerk): Unit = {
    ("test() name=" + c.name + " salary=" + c.sal)
  }
}

class Human{
  // 包访问权限
  // private[visit] ：1，仍然是private 2，在visit包下也可以使用name，相当于扩大了访问的范围
  private[visit] val name:String = "Jack"
}
object Human{
  def sayHi(h:Human): Unit = {
    println(s"${h.name} is saying Hi")
  }
}