package secondary.array

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
  *               给定一个按照升序排列的整数数组 nums，和一个目标值 target。
  *               找出给定目标值在数组中的开始位置和结束位置。
  *               你的算法时间复杂度必须是 O(log n) 级别。
  *               如果数组中不存在目标值，返回 [-1, -1]。
  * @author: sunhaiting
  * @create: 2020-03-12 11:04
  **/
object ThirtyFourSearchRange {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 4, 4, 5)
    val ints = searchRange(arr, 4)
    println(ints.toBuffer)

  }

  /**
    *
    * @param nums
    * @param target
    * @return
    */
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {

    val arr = new Array[Int](2)
    var left = 0
    var right = nums.length - 1
    //找到右边界
    breakable {
      while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums(mid) > target) {
          right = mid - 1
        } else if (nums(mid) < target) {
          left = mid + 1
        } else {
          if (mid == nums.length - 1 || nums(mid + 1) > target) {
            arr(1) = mid
            break()
          } else {
            left = mid + 1
          }
        }
      }
    }

    left =0
    right =nums.length-1
    //找到左边界
    breakable {
      while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums(mid) > target) {
          right = mid - 1
        } else if (nums(mid) < target) {
          left = mid + 1
        } else {
          if (mid == 0 || nums(mid - 1) < target) {
            arr(0) = mid
            break()
          } else {
            right = mid - 1
          }
        }
      }
    }
    arr
  }


}
