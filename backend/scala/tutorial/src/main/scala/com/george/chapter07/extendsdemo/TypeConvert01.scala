package com.george.chapter07.extendsdemo

object TypeConvert01 {
  //
  def main(args: Array[String]): Unit = {

    // classOf的使用，可以得到类名

    println(classOf[PP100])
    val s = "k"
    println(s.getClass.getName) //使用反射机制

    // isInstanceOf asInstanceOf

    var p = new P100
    var pp = new PP100
    // 将子类引用给父类（向上转型，自动）
    p = pp
    // 将父类的引用重新转成子类的引用(多态),向下转型
    var pp2 = p.asInstanceOf[PP100]








  }
}
class P100 {
  var name: String = "tom"

  def printName() {
    println(s"P printName() ${this.name}")
  }
}

class PP100 extends P100 {
  override def printName(): Unit = {

    println(s"PP printName() ${this.name}")

    // 如果在子类中需要使用父类方法，使用super关键字
    super.printName()
  }
  def sayHello(): Unit = {
    println("hello")
  }
}

