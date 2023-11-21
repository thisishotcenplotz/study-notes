package com.jiyu.chapter06.oop

object CatDemo {
  def main(args: Array[String]): Unit = {
    val tom = new Cat
    tom.name = "tom"
    tom.age = 10
    tom.color = "white"
  }
}

class Cat{
  //当声明了一个var name:String 时，在底层对应生成 private name
  //同时会生成两个public方法 name()  类似 getter; name_$eq() 对应setter
  var name:String = _
  var age:Int = _
  var color:String = _

}
