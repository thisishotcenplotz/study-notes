package com.george.chapter05.ExceptionHandle

object throwDemo {
  def main(args: Array[String]): Unit = {
//    val rst = test()
//    println(rst.toString)

    //如果希望在test()抛出异常后，代码可以继续执行

    try{
      test()
    }catch {
      case e:Exception => println(e.getMessage)
    }

    println("ok....")


  }
  def test():Nothing = {
    throw new Exception("error......")
  }

}
