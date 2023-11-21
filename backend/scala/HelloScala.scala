// object 表示一个伴生对象;这里我们可以简单理解为一个对象
// HelloScala就是对象名字，它底层真正对应的是HelloScala$，对象是HelloScala$的一个静态对象MODULE$
//

object HelloScala {
  // :Unit 表示该函数返回值为空
  def main(args: Array[String]): Unit = {
    println("Hello World Scala!");
  }
}