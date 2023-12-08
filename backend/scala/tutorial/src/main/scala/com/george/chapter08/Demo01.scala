package com.george.chapter08

object Demo01 {
  def main(args: Array[String]): Unit = {
    println(ScalaPerson.sex)
    ScalaPerson.sayHi()
  }
}


// 1. 当在同一个文件中，同名的class 和 object
// 2. class 称为伴生类，将非静态的内容写到该类中
// 3. object 称为伴生对象，将静态的内容写入到该对象中
// 4. class 在编译后，底层生成 XXX.class
// 5. object 在编译后底层个生成 XXX$.class
// 6. 对于伴生对象里边的内容，我们可以直接通过  xxx.xxx的方式直接使用

// 类
class ScalaPerson {
  var name: String = _

}

// 伴生对象
object ScalaPerson {
  var sex: Boolean = true
  def sayHi(): Unit = {
    println("Hi")
  }
}
