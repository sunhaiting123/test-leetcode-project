package simple.array

import java.util

import scala.collection.mutable

/**
  *
  * @description: 448. 找到所有数组中消失的数字
  *               给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
  *               找到所有在 [1, n] 范围之间没有出现在数组中的数字。
  *               您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
  * @author: sunhaiting
  * @create: 2020-02-28 16:33
  **/
object FourHundredAndFortyEightFindDisappearedNumbersScala {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 3, 3, 5, 4, 7, 3)
    val ints = findDisappearedNumbers(nums)
    println(ints.toBuffer)

  }

  /**
    * 遍历输入数组的每个元素一次。
    * 我们将把 |nums[i]|-1 索引位置的元素标记为负数。即 nums[|nums[i]|- 1] -1  。
    * 然后遍历数组，若当前数组元素 nums[i] 为负数，说明我们在数组中存在数字 i+1。
    *
    *
    * @param nums
    * @return
    */
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val list = new util.ArrayList[Int]()

    for (i <- 0 until nums.length) {
      //有一个取绝对值，可能在之前这个值已经被改变成负数
      val index = math.abs(nums(i)) - 1
      if (nums(index) > 0) {
        nums(index) = nums(index) * (-1)
      }
    }

    for (i <- 0 until nums.length) {
      if (nums(i) > 0) {
        list.add(i + 1)
      }
    }
    import scala.collection.JavaConverters._
    list.asScala.toList
  }

}
