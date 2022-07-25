package simple.array

import scala.collection.mutable

/**
  *
  * @description: 496. 下一个更大元素 I
  *               给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
  *               找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
  *               nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
  *               如果不存在，对应位置输出-1。
  * @author: sunhaiting
  * @create: 2020-02-29 21:26
  **/
object FourHundredAndNinetySixNextGreaterElement {
  def main(args: Array[String]): Unit = {
    val arr1 = Array(2, 1 ,8)
    val arr2 = Array(2,3,5,1,8,7,3)
    val ints = nextGreaterElement(arr1, arr2)
    println(ints.toBuffer)

  }

  /**
    * 单调栈
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val stack = new mutable.Stack[Int]()
    val map = new mutable.HashMap[Int, Int]()
    val arr = new Array[Int](nums1.length)

    for (i <- 0 until nums2.length) {

      while (!stack.isEmpty && nums2(i) > stack.top) {
        map.put(stack.pop(), nums2(i))
      }
      stack.push(nums2(i))
    }
    for (i <- 0 until nums1.length) {
      val value = map.getOrElse(nums1(i), -1)
      arr(i) = value
    }
    arr
  }
}
