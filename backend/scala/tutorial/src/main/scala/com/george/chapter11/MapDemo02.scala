package com.george.chapter11

object MapDemo02 {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 说明
    // 1. l1.map(example) 到底做了什么？
    // 将l1这个集合的元素依次遍历
    // 2. 将各个元素传递给example这个函数，并返回一个新的Int值
    // 3. 将得到的新的值放入到一个新的集合并返回
    // 4. 因此example这个函数是被调用了10次
    l1.map(example).foreach(println)
    println("-----------------------------")

    val l = MyList
    println(l.apply().map(_ * 2))

  }

  def example(i: Int): Int  = {
    println(s"Current i is: ${i}")
    i * 2
  }




}

// 深刻理解map的函数映射机制 --> 模拟实现
class MyList {
  val l1 = List(3,5,7,9)
  var l2 = List[Int]()

  def map(f: Int => Int ): List[Int] = {

    for(i <- l1){
       l2 = l2 :+ f(i )
    }
    l2
  }
}

object MyList{
  def apply(): MyList = new MyList()

}
