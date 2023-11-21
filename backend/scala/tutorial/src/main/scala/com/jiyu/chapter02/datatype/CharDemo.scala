package com.jiyu.chapter02.datatype

object CharDemo {
  def main(args: Array[String]): Unit = {
    var char1:Char = 97
    //当输出一个char类型时，他会输出该数字对应的字符（码值表 unicode）
    println(char1)

    //char 可以当做数字进行运算
    var char2:Char = 'a'
    var num = 10 +char2
    println(num)
  }
}
