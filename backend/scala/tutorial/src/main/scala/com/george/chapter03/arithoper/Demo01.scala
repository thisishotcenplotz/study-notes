package com.george.chapter03.arithoper

import java.text.DecimalFormat

object Demo01 {
  def main(args: Array[String]): Unit = {
    var r1:Int = 10 / 3
    println(r1)
    var r2:Double = 10 / 3
    println(r2)
    var r3:Double = 10000.0 / 3
    println(r3.formatted("%.2f"))
    println(toDecimal(r3))
    println(new DecimalFormat(",###.00").format(BigDecimal(r3)))

    println(weeksToBreak(97))
  }

  private def toDecimal(num:Double):BigDecimal = {
    return BigDecimal(num).setScale(2,BigDecimal.RoundingMode.HALF_UP)
  }

  private def weeksToBreak(days:Int):String = {
    val day = days % 7
    val week = days/7
    val rst = s"There are ${week} weeks and ${day} left before the break"
    return rst
  }

}
