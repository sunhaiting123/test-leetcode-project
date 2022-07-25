package simple.array

import java.util

import scala.collection.mutable

/**
  *
  * @description: 350. 两个数组的交集 II
  *               给定两个数组，编写一个函数来计算它们的交集。
  *               如果给定的数组已经排好序呢？你将如何优化你的算法？
  *               如果 nums1 的大小比 nums2 小很多，哪种方法更优？
  *               如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
  * @author: sunhaiting
  * @create: 2020-01-17 11:18
  **/
object ThreeHundredAndFiftyIntersect {
  def main(args: Array[String]): Unit = {
    val num1 = Array(50, 6, 9, 20, 30, 50, 10, 20)
    val num2 = Array(50, 60, 9, 20, 35, 50)
    val ints = intersect2(num1, num2)
    println(ints.toBuffer)

  }

  /**
    * 使用hashMap存储较小的数组
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    if (nums1.length > nums2.length) {
      intersect(nums2, nums1)
    }
    val map = new mutable.HashMap[Int, Int]()
    for (num <- nums1) {
      map.put(num, map.getOrElse(num, 0) + 1)
    }
    var k = 0
    for (num <- nums2) {
      val value = map.getOrElse(num, 0)
      if (value != 0) {
        nums1(k) = num
        k = k + 1
        map.put(num, value - 1)
      }
    }
    util.Arrays.copyOfRange(nums1, 0, k)

  }

  /**
    * 双指针法
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def intersect2(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    util.Arrays.sort(nums1)
    util.Arrays.sort(nums2)
    var i = 0
    var j = 0
    var k = 0
    while (i < nums1.length && j < nums2.length) {
      if (nums1(i) == nums2(j)) {
        nums1(k) = nums1(i)
        k = k + 1
        i = i + 1
        j = j + 1
      } else if (nums1(i) < nums2(j)) {
        i = i + 1
      } else {
        j = j + 1
      }
    }
    util.Arrays.copyOfRange(nums1, 0, k)
  }


}
