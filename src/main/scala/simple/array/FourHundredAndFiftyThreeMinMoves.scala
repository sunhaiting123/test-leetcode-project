package simple.array

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 453. 最小移动次数使数组元素相等
  *              给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。
  *              每次移动可以使 n - 1 个元素增加 1。
  * @author: sunhaiting
  * @create: 2020-02-28 18:11
  **/
object FourHundredAndFiftyThreeMinMoves {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    val i = minMoves3(arr)
    println(i)
  }

  /**
    * 暴力法
    *
    * @param nums
    * @return
    */
  def minMoves(nums: Array[Int]): Int = {
    var count = 0
    var min = 0
    var max = nums.length - 1
    breakable(
      while (true) {
        for (i <- 0 until nums.length) {
          if (nums(i) > nums(max)) {
            max = i
          }
          if (nums(i) < nums(min)) {
            min = i
          }
        }
        if (nums(min) == nums(max)) {
          break()
        }
        for (i <- 0 until nums.length) {
          if (i != max) {
            nums(i) = nums(i) + 1
          }

        }
        count = count + 1
      }
    )
    count
  }


  /**
    * 暴力法优化
    *
    * @param nums
    * @return
    */
  def minMoves2(nums: Array[Int]): Int = {
    java.util.Arrays.sort(nums)
    var count = 0
    var min = 0
    var max = nums.length - 1
    breakable(
      while (true) {
        for (i <- 0 until nums.length) {
          if (nums(i) > nums(max)) {
            max = i
          }
          if (nums(i) < nums(min)) {
            min = i
          }
        }
        val diff = nums(max) - nums(min)
        if (diff == 0) {
          break()
        }
        count = count + diff
        for (i <- 0 until nums.length) {
          if (i != max) {
            nums(i) = nums(i) + diff
          }

        }
      }
    )
    count
  }

  /**
    * 逆向思维
    * 给n-1个数加1相当于给剩下的一个数减1
    *
    * @param nums
    * @return
    */
  def minMoves3(nums: Array[Int]): Int = {
    var count = 0
    var min = Int.MaxValue
    for (i <- 0 until nums.length) {
      count = count + nums(i)
      min = math.min(min, nums(i))
    }
    count - min * nums.length
  }

  /**
    *逆向思维优化
    * @param nums
    * @return
    */
  def minMoves4(nums: Array[Int]): Int = {
    var count = 0
    var min = Int.MaxValue
    for (i <- 0 until nums.length) {
      min = math.min(min, nums(i))
    }

    for (i <- 0 until nums.length) {
      count = count + (nums(i) - min)
    }
    count
  }
}
