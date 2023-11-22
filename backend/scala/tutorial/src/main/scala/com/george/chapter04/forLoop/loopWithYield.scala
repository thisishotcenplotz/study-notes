package com.george.chapter04.forLoop

object loopWithYield {
  def main(args: Array[String]): Unit = {
    // 将遍历过程中处理的结果返回到一个新vector集合中，使用yield关键字
    // 下面这个方式就体现出了Scala的一个重要语法特点，就是将一个集合中的各个数据
    //  进行处理，并返回给新的集合
    //
    val rst = for(i <- 1 to 10) yield {
      if(i % 2 == 0) i
    }
    println(rst)


  }
}
