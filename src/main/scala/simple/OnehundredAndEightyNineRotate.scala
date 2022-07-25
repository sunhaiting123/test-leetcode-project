package simple

import java.util

/**
  *
  * @description: 189.给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
  * @author: sunhaiting
  * @create: 2019-11-22 19:43
  **/
object OnehundredAndEightyNineRotate {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    println(arr.toBuffer)
    rotate(arr, 3)
    //    rotate2(arr,3)
    //    rotate3(arr,3)
    println(arr.toBuffer)
  }

  /**
    * 输入: [1,2,3,4,5,6,7] 和 k = 3
    * 输出: [5,6,7,1,2,3,4]
    * 解释:
    * 向右旋转 1 步: [7,1,2,3,4,5,6]
    * 向右旋转 2 步: [6,7,1,2,3,4,5]
    * 向右旋转 3 步: [5,6,7,1,2,3,4]
    *
    * @param nums
    * @param k
    */
  def rotate(nums: Array[Int], k: Int): Unit = {
    val arr = new Array[Int](nums.length)


    for (i <- 0 until nums.length) {
      arr((i + k) % nums.length) = nums(i)
    }
    for (i <- 0 until nums.length) {
      nums(i) = arr(i)
    }
  }

  /**
    * 使用环状替换
    *
    * @param nums
    * @param k
    */
  def rotate2(nums: Array[Int], k: Int): Unit = {
    var k1 = k
    k1 = k1 % nums.length
    var count = 0
    var start = 0

    while (count < nums.length) {
      var current = start
      var pre = nums(start)
      do {
        val next = (current + k1) % nums.length
        val temp = nums(next)
        nums(next) = pre
        pre = temp
        current = next
        count = count + 1
      } while (start != current)
      start = start + 1
    }
  }

  /**
    * 反转
    * 原始数组                  : 1 2 3 4 5 6 7
    * 反转所有数字后             : 7 6 5 4 3 2 1
    * 反转前 k 个数字后          : 5 6 7 4 3 2 1
    * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    *
    * @param nums
    * @param k
    */
  def rotate3(nums: Array[Int], k: Int): Unit = {
    var k1 = k
    k1 = k1 % nums.length
    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k1 - 1)
    reverse(nums, k1, nums.length - 1)

  }

  def reverse(nums: Array[Int], start: Int, end: Int): Unit = {

    var start1 = start
    var end1 = end
    while (start1 < end1) {
      val temp = nums(start1)
      nums(start1) = nums(end1)
      nums(end1) = temp
      start1 = start1 + 1
      end1 = end1 - 1
    }
  }


}
