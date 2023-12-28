package com.george.chapter08.innerClass

object ScalaInnerClassDemo {
  def main(args: Array[String]): Unit = {
    val outer1 = new ScalaOuterClass
    val outer2 = new ScalaOuterClass

    // 在scala中，创建成员内部类语法是
    // 对象.内部类 的方式创建，这里语法可以看出在scala中，默认情况下内部类实例和外部对象关联
    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    //创建静态内部类实例

    val staticInner = new ScalaOuterClass.ScalaStaticInnerClass()
    inner1.info()


  }

}

class ScalaOuterClass {
  myOuter =>  // 起别名
  private val name:String = "scot"
  private val salary:Double  = 100.20

  class ScalaInnerClass {
    def info(): Unit = {
//      println(s"name=${ScalaOuterClass.this.name}  ---> salary:${ScalaOuterClass.this.salary}")
      println(s"name=${myOuter.name}  ---> salary:${myOuter.salary}")
    }


    // 下面的 ScalaOuterClass#ScalaInnerClass 的类型投影的作用是屏蔽外部对象对内部类对象的影响
    def test(ic:ScalaOuterClass#ScalaInnerClass): Unit = {
      println(ic)
    }

  }
}

object ScalaOuterClass {
  class ScalaStaticInnerClass {}
}

