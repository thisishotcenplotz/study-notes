package com.jiyu.chapter04.whileLoop

import scala.util.control.Breaks.{break, breakable}

object whileContinue {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to 10 if i != 2 && i != 3) {
      println(i)
    }

  }
}
