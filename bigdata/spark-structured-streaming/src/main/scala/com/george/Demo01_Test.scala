package com.george

object Demo01_Test {
  def main(args: Array[String]): Unit = {
//    // spark session setup
//    val conf = new SparkConf().setAppName("struct").setMaster("local[*]")
//    val spark = SparkSession.builder().config(conf).getOrCreate()
//    spark.sparkContext.setLogLevel("warn")
//    import spark.implicits._
//
//    val df = spark.readStream
//      .format("socket")
//      .option("host", "localhost")
//      .option("port", 9999)
//      .load()
//
//    val result = df.as[String]
//      .flatMap(_.split(" "))
//      .createOrReplaceTempView("the_table")
//
//
////    val rst = spark.sql(
////      """
////        |
////        |select
////        | value as word
////        | ,count(*) as cnt
////        |from the_table
////        |group by word
////        |""".stripMargin)
//
//    val rst2 = spark.sql(
//      """
//        |select
//        | value as word
//        |from the_table
//        |""".stripMargin)
//
//
//    rst2.writeStream
//      .format("console")
//      .outputMode("append")
//      .start()
//      .awaitTermination()
  }
}
