package com.george
import _root_.scala.io.Source
object Test_a {
  def main(args: Array[String]): Unit = {
    val data = Source.fromFile("src/main/scala/com/george/sample.txt")
    val cleanData = data
      .mkString
      .replace("，", "")
      .replace("。", "")
      .replace("、", "")
      .replace("：", "")
      .replace("“", "")
      .replace("”", "")
      .replace("——", "")
      .replace("1", "")
      .replace("2", "")
      .replace("3", "")
      .replace("4", "")
      .replace("5", "")
      .replace("6", "")
      .replace("7", "")
      .replace("8", "")
      .replace("9", "")
      .replace("0", "")
      .replace("\n", "")
      .replace("…", "")
      .replace("；", "")
      .split("")
      .map((_,1))
      .groupBy(_._1)
      .mapValues(list => list.map(_._2).sum)
      .toList
      .sortWith(_._2 < _._2)
      .foreach(println)
  }
}
