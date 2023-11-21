package com.jiyu.chapter01.vars

object VarDemo02 {
  def main(args: Array[String]): Unit = {

    //类型推到
    var num = 10
    // 证明num是Int
    println(num.isInstanceOf[Int])

    //类型确定后，就不能改，说明Scala是强类型语言

    //scala 设计者为什么设计var 和val
    //(1) 在实际编程中，我们更多的需求是获取/创建一个对象后，读取该对象的属性，或者修改对象的属性值,但是我们很少去改变这个对象本身
    // 这是，我们就可以使用value
    //(2) 因为val没有线程安全问题，因此效率高，Scala设计者推荐我们尽量使用val
    //(3) 如果对象需要改变则使用 var

    val dog = new Dog
    dog.age = 5
    dog.name = "A"
  }
}


class Dog {
  var age:Int = _
  var name:String = _

}