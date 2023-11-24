package com.george.chapter07.extendsdemo

object TypeConvert02 {
  //
  def main(args: Array[String]): Unit = {
    val student = new Student
    val employee = new Employee

    test(student)
    test(employee)
  }

  // 写一个参数多态代码
  // 因为在OOP中一个父类的引用可以接收所有子类的引用，多态（参数多态）
  def test(p: Person): Unit = {
    //使用scala中的类型检测和转换
    if (p.isInstanceOf[Employee]) {
      // p.asInstanceOf[Employee], 对p的类型没有任何变化，而是返回的是Employee
      p.asInstanceOf[Employee].showInfo()
    } else if (p.isInstanceOf[Student]) {
      p.asInstanceOf[Student].smile()
    } else {
      println("转换失败")
    }
  }

  class Person {
    def printName(): Unit = {
      println("Person printName")
    }

    def sayOK(): Unit = {
      println("Person sayOK")
    }
  }

  class Student extends Person {
    val stuID = 100

    override def printName(): Unit = {
      println("Student printName")
    }

    def smile(): Unit = {
      println(s"student id is ${this.stuID}")
    }
  }

  class Employee extends Person {

    val employeeID = 200

    override def printName(): Unit = {
      println("Employee printName")
    }

    def showInfo(): Unit = {
      println(s"employee id is ${this.employeeID}")
    }
  }
}



