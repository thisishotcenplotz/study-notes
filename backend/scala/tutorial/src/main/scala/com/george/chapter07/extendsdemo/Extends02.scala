package com.george.chapter07.extendsdemo



object Extends02 {
  // 在Scala中，子类继承了父类的所有属性；
  // 但是private的属性和方法无法访问
  def main(args: Array[String]): Unit = {
    val sub = new Sub
    sub.sayOK()
    sub.test100()

  }
}


class Base {
  var n1:Int = 1
  protected var n2:Int = 2
  private  var n3: Int = 3

  def test100(): Unit = {
    println("base 100")
  }

  protected def test200(): Unit = {
    println("base 200")
  }

  private def test300(): Unit = {
    println("base 300")
  }

}

class Sub extends Base{
  def sayOK(): Unit = {
    this.n1 =20
    this.n2 = 40
    println(s"n1:${this.n1} n2:${this.n2}")
    this.test200()
  }
}