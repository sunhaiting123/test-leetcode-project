package simple.binary

import java.util

/**
  *
  * @description: 401. 二进制手表
  * @author: sunhaiting
  * @create: 2020-01-30 20:58
  **/
object FourHundredAndOneReadBinaryWatch {
  def main(args: Array[String]): Unit = {
    val strings = readBinaryWatch2(8)
    println(strings.toBuffer)
  }


  /**
    * 暴力遍历法，计算出每一个时间对应的手表中LED灯亮的个数
    *
    * @param num
    * @return
    */
  def readBinaryWatch(num: Int): List[String] = {

    val list = new util.ArrayList[String]()

    for (i <- 0 until 12) {
      for (j <- 0 until 60) {
        if (numberOfOne(i) + numberOfOne(j) == num) {
          val j1 = if (j >= 10) {
            j
          } else {
            "0" + j
          }
          val time = i + ":" + j1
          list.add(time)
        }
      }
    }
    import scala.collection.JavaConverters._
    list.asScala.toList
  }


  def numberOfOne(num: Int): Int = {
    var num1 = num
    var count = 0
    while (num1 > 0) {
      if ((num1 & 1) != 0) {
        count = count + 1
      }
      num1 = num1 >> 1
    }
    count
  }

  /**
    * 直接使用bitcount方法计算一个数中1的个数
    * Java中的Integer.bitCount(i)的返回值是i的二进制表示中1的个数
    *
    * @param num
    * @return
    */
  def readBinaryWatch2(num: Int): List[String] = {
    val times = new util.ArrayList[String]()
    for (i <- 0 until 12) {
      for (j <- 0 until 60) {
//        if (Integer.bitCount(i * 64 + j) == num)
        if ( Integer.bitCount(i)+Integer.bitCount(j) == num)
          times.add(String.format("%d:%02d", int2Integer(i), int2Integer(j)))
      }
    }
    import scala.collection.JavaConverters._
    times.asScala.toList
  }



}
