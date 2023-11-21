package com.george.chapter06.constructor

object Demo01 {
  def main(args: Array[String]): Unit = {
//    val p1 = new Person("jackie", 20)
//    p1.showInfo()
//    val p2 = new Worker("Smith")
//    println(p2.name)
//    val p3 = new Worker2("Smith")
//    println(p3.name)
//    println(p3.inName)
    val p4 = new Worker3
    p4.setAge(30)
    p4.setName("smith")
    println(p4.getAge)
    println(p4.getName)


    println("-" * 10)

    val www = new WWW("smith", 10)
    println(www.getAge)
    println(www.getName)
  }
}

