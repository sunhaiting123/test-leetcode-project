package difficult

import java.util

/**
  *
  * @description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
  *               请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
  *               你可以假设 nums1 和 nums2 不会同时为空。
  * @author: sunhaiting
  * @create: 2019-11-05 21:55
  **/
object FindMedianSortedArrays {
  def main(args: Array[String]): Unit = {
    val nums1: Array[Int] = Array(1, 2, 3, 4, 5)
    val nums2: Array[Int] = Array(6, 7, 8, 9)
    val d: Double = findMedianSortedArrays(nums1, nums2)
    val d2: Double = findMedianSortedArrays2(nums1, nums2)
    println(d)
    println(d2)


  }

  /**
    * nums1 = [1, 2]
    * nums2 = [3, 4]
    * 则中位数是 (2 + 3)/2 = 2.5
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var arr: util.ArrayList[Int] = new util.ArrayList[Int]()
    for (i <- 0 until nums1.length) {
      arr.add(nums1(i))
    }
    for (i <- 0 until nums2.length) {
      arr.add(nums2(i))
    }
    for (i <- 0 until arr.size() - 1) {
      for (j <- 0 until arr.size() - 1 - i) {
        var j1: Int = arr.get(j)
        var j2: Int = arr.get(j + 1)
        if (j1 > j2) {
          var temp = 0
          temp = j2
          j2 = j1
          j1 = temp
        }
      }
    }
    val length = arr.size()
    if (length % 2 == 0) {
      (arr.get((length / 2) - 1) + arr.get(length / 2)).toDouble / 2
    } else {
      arr.get((length - 1) / 2).toDouble
    }
  }


  def findMedianSortedArrays2(a1: Array[Int], b1: Array[Int]): Double = {
    var m = a1.length
    var n = b1.length
    var A = a1
    var B = b1
    if (m > n) {
      //交换数组
      val tmpArr = A
      A = B
      B = tmpArr
      //交换m,n
      val tmp = m
      m = n
      n = tmp
    }
    var bool = true
    var result = 0.0
    var iMin = 0
    var iMax = m
    val halfLen = (m + n + 1) / 2
    while (iMin <= iMax && bool) {
      val i = (iMin + iMax) / 2
      val j = halfLen - i
      if (i < iMax && B(j - 1) > A(i)) {
        iMin = i + 1 // i is too small
      } else if (i > iMin && A(i - 1) > B(j)) {
        iMax = i - 1 // i is too big
      } else { // i is perfect
        var maxLeft = 0
        if (i == 0) {
          maxLeft = B(j - 1)
        } else if (j == 0) {
          maxLeft = A(i - 1)
        } else {
          maxLeft = Math.max(A(i - 1), B(j - 1))
        }
        if ((m + n) % 2 == 1) {
          result = maxLeft
          bool = false
        }
        if (bool) {
          var minRight = 0
          if (i == m) {
            minRight = B(j)
          } else if (j == n) {
            minRight = A(i)
          } else {
            minRight = Math.min(B(j), A(i))
          }
          result = (maxLeft + minRight) / 2.0
        }
      }
    }
    result
  }


}

