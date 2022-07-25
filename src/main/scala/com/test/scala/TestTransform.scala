package com.test.scala

/**
  *
  * @description:
  * @author: sunhaiting
  * @create: 2020-05-30 12:34
  **/
object TestTransform {
  def main(args: Array[String]): Unit = {

    implicit  def transform(d:Double):Int={
      d.toInt
    }

    val i:Int = 5.0
    println(i)
  }

  val list = List(1,4,3,2)
  list.sortBy(x=>x).reverse
  list.reduce(_+_)

}
