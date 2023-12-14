package com.george.chapter08.extendsTrait

object Demo01 {
  def main(args: Array[String]): Unit = {

  }
  trait LoggedException extends Exception{
    def log(): Unit = {
      println(getMessage())
    }
  }

  class UnHappyException extends LoggedException{
    override def getMessage: String = "I'm not happy!!! I need a Big Data Engineer Job! ASAP!!!"
  }

  class UnHappyException2 extends IndexOutOfBoundsException with LoggedException {
    override def getMessage: String = "I'm not happy!!! I need a Big Data Engineer Job! ASAP!!!"
  }


}
