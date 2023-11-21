package com.bigdata.spark.core.disCalSim

class SubTask extends Serializable {
  var data:List[Int] = _
  var logic:(Int)=>Int = _

  def compute() = {
    data.map(logic)
  }




}
