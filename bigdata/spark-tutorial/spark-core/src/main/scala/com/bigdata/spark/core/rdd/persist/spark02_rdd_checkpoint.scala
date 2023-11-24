package com.bigdata.spark.core.rdd.persist

import org.apache.spark.{SparkConf, SparkContext}

object spark02_rdd_checkpoint {
  // cache: 将数据临时存储在内存中进行数据重用;
  //        会在血缘关系中添加新的依赖。
  //        一旦出现问题，可以从头读取数据。
  // persist: 将数据临时存储在磁盘文件中进行数据重用;
  //          但是设计到磁盘IO，所以性能较低，但是数据安全;
  //          如果作业执行完毕，临时保存的数据文件就会丢失
  // checkpoint: 可以将数据长久的保存在磁盘文件中，进行数据的重用；
  //             但是数据是安全的；为了保证数据安全，所以一般情况下，会独立执行作业，效率更低；
  //             为了能够提高效率，一般会和cache联合使用；
  //             执行过程中，会切断血缘关系，重新建立新的血缘关系。
  //             checkpoint等同于改变数据源


  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd persist")
    val spark = new SparkContext(sparkConf)

    val data = List("hello scala", "hello spark")

    val rdd = spark.parallelize(data)

    val flatRDD = rdd.flatMap(_.split(" "))

    val mapRDD = flatRDD.map(word => {
      (word, 1)
    })
    mapRDD.cache()
    println(mapRDD.toDebugString)

    // ----------------------------------------------------

    val reduceRDD = mapRDD.reduceByKey(_ + _)
    val sortedRDD = reduceRDD.sortBy(_._2, false)
    sortedRDD.collect().foreach(println)
    println("****************************************")
    println(mapRDD.toDebugString)



  }
}
