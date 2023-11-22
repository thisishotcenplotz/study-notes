package com.george.chapter06.constructor
import scala.beans.BeanProperty


//如果主构造器是Worker(inName:String) 写的，那么inName就是一个局部变量，范围就在主构造器内
//
class Worker(inName:String) {
  var name:String = inName
}


//如果主构造器是Worker2(val inName:String) 写的，那么inName就是一个private的只读属性
class Worker2(val inName:String){
  var name:String = inName
}

class Worker3{
  @BeanProperty var name:String = _
  @BeanProperty var age:Int = _
  def this(name:String, age:Int){
    this
    this.name = name
    this.age = age
  }
}

class WWW{
  @BeanProperty var name:String = _
  @BeanProperty var age:Int = _

  def this(theName:String,theAge:Short){
    this()
    this.name = theName
    this.age = theAge
  }
}