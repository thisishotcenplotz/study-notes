package com.george.chapter07.extendsdemo

object scalaFieldOverrideDetail01 {
  def main(args: Array[String]): Unit = {
    val a0 = new SubA03
    println(a0.getAge())

  }


  // 在A03中，you一个抽象的字段（属性）
  // 1. 抽象的字段（属性）：就是没有初始化的字段（属性）
  // 2. 当一个类含有抽象属性时，则该类需要标记为abstract
  // 3. 对于抽象的属性，在底层不会生成对应的属性声明，而是生成两个对应的抽象方法
  abstract class A03{
    var name:String
    var age:Int = 10

  }

  class SubA03 extends A03{
    // 1. 如果我们在子类中去重写父类的抽象属性，本质是实现了抽象方法
    // 2. 因此我们这里可以写override，也可以不写
    override var name: String = _

    def getAge(): Int = {
      this.age
    }
  }

}
