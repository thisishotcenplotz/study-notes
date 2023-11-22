package com.george.chapter07.scalapackage

import scala.beans.BeanProperty

object packageDemo02 {
  def main(args: Array[String]): Unit = {

  }
}

class Manager{
//  @BeanProperty var age: Int = _

//  @scala.beans.BeanProperty var age: Int = _

  @_root_.scala.beans.BeanProperty var age: Int = _


  def this(age:Int){
    this()
    this.age = age
  }

}