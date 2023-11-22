package com.george.chapter01

object PrintDemo {
  def main(args: Array[String]): Unit = {
    var str1:String = "Hello"
    var str2:String = " World"

    println(str1 + str2)
    var name:String = "Tom";
    var age:Int = 10;
    var sal:Float = 10.67f;
    var height: Double = 180.15;

    printf("name is %s age is %d salary is %.2f and height is %.2f",name,age,sal,height)
    println()
    println(f"name:${name} age:${age} salary:${sal} height:${height}")
  }

}
