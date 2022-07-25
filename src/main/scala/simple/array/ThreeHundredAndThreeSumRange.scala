package simple.array

import java.util

/**
  *
  * @description: 303. 区域和检索 - 数组不可变
  *               给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
  * @author: sunhaiting
  * @create: 2020-01-15 16:50
  **/
object ThreeHundredAndThreeSumRange {
  val nums = Array(-2, 0, 3, -5, 2, -1)

  def main(args: Array[String]): Unit = {
    numArray3(nums)
    val i = sumRange3(2, 5)
    println(i)
  }

  /**
    * 暴力求解
    *
    * @param i
    * @param j
    * @return
    */
  def sumRange(i: Int, j: Int): Int = {
    var sum = 0
    for (k <- i to j) {
      sum += nums(k)
    }
    sum
  }

  /**
    * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
    * 用0~j的和减去0~i的和
    * sumRange(0, 2) -> 1
    * sumRange(2, 5) -> -1
    * sumRange(0, 5) -> -3
    *
    * @param i
    * @param j
    * @return
    */
  def sumRange2(i: Int, j: Int): Int = {
    sums(j + 1) - sums(i)

  }

  var sums: Array[Int] = _

  def numArray2(nums: Array[Int]): Unit = {
    sums = new Array[Int](nums.length + 1)
    for (i <- 0 until nums.length) {
      sums(i + 1) = sums(i) + nums(i)
    }
  }


  /**
    * 所有可能的情况做缓存
    *
    */
  val map: util.HashMap[(Int, Int), Int] = new util.HashMap[(Int, Int), Int]()

  def numArray3(arr: Array[Int]): Unit = {
    for (i <- 0 until arr.length) {
      var sum = 0
      for (j <- i until arr.length) {
        sum = sum + arr(j)
        map.put((i, j), sum)
      }
    }
  }

  def sumRange3(i: Int, j: Int): Int = {
    map.get((i, j))
  }


}
