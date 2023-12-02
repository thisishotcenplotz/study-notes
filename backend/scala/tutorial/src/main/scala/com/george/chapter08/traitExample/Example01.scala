package com.george.chapter08.traitExample

object Example01 {
  def main(args: Array[String]): Unit = {

  }

  class Conversions {
    def inchesToCentimeters(value: Double) = value * 2.54

    def gallonToLiters(value: Double) = value * 3.78541178

    def milesToKilometers(value: Double) = value * 1.609344
  }

  class Point(x: Int = 0, y: Int = 0) {
    var x1 = x
    var y1 = y
  }

  object Point {
    def apply(x:Int = 0, y:Int = 0) = new Point(x,y)
  }




}
