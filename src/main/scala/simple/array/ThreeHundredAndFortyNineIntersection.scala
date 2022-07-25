package simple.array

import java.util

/**
  *
  * @description: 349. 两个数组的交集
  *               给定两个数组，编写一个函数来计算它们的交集。
  *               输出结果中的每个元素一定是唯一的。
  *               我们可以不考虑输出结果的顺序。
  * @author: sunhaiting
  * @create: 2020-01-16 15:04
  **/
object ThreeHundredAndFortyNineIntersection {
  def main(args: Array[String]): Unit = {
    val num1 = Set(5, 6, 9, 20, 30, 45)
    val num2 = Set(50, 60, 9, 20, 35, 55)
    val ints = intersection3(num1.toArray, num2.toArray)
    println(ints.toBuffer)

  }

  /**
    * 使用两个hash表
    * set1.&(set2)
    * set1.intersect(set2)
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val set1 = new util.HashSet[Int]()
    val set2 = new util.HashSet[Int]()

    for (num1 <- nums1) {
      set1.add(num1)
    }

    for (num2 <- nums2) {
      if (set1.contains(num2)) {
        set2.add(num2)
      }
    }
    val value: Array[AnyRef] = set2.toArray()
    val ints: Array[Int] = value.map(x => {
      x.toString.toInt
    })
    ints
  }

  /**
    * 双指针
    * 先将两个数组排序
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def intersection2(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    util.Arrays.sort(nums1)
    util.Arrays.sort(nums2)

    val set = new util.HashSet[Int]()
    var i = 0
    var j = 0
    while (i < nums1.length && j < nums2.length) {
      if (nums1(i) == nums2(j)) {
        set.add(nums1(i))
        i = i + 1
        j = j + 1
      } else if (nums1(i) > nums2(j)) {
        j = j + 1
      } else {
        i = i + 1
      }
    }
    val value: Array[AnyRef] = set.toArray()
    val ints: Array[Int] = value.map(x => {
      x.toString.toInt
    })
    ints
  }

  /**
    * 二分查找
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def intersection3(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    util.Arrays.sort(nums1)

    val set = new util.HashSet[Int]()
    for (num <- nums2) {
      if (binarySearch(nums1, num)) {
        set.add(num)
      }
    }

    val value: Array[AnyRef] = set.toArray()
    val ints: Array[Int] = value.map(x => {
      x.toString.toInt
    })
    ints
  }


  def binarySearch(nums: Array[Int], target: Int): Boolean = {
    var flag = true
    var result = false
    var left = 0
    var right = nums.length - 1
    while (left <= right && flag) {
      val mid = left + (right - left) / 2
      if (target == nums(mid)) {
        result = true
        flag = false
      } else if (target > nums(mid)) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    result
  }
}
