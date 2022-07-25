package secondary.array

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 153. 寻找旋转排序数组中的最小值
  *               假设按照升序排序的数组在预先未知的某个点上进行了旋转。
  *               ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
  *               请找出其中最小的元素。
  *               你可以假设数组中不存在重复元素。
  * @author: sunhaiting
  * @create: 2020-03-11 23:55
  **/
object OnehundredAndFiftyThreeFindMin {
  def main(args: Array[String]): Unit = {
    val nums = Array(5, 6, 7, 8, 1, 2, 3, 4)
    val i = findMin2(nums)
    println(i)
  }

  def findMin(nums: Array[Int]): Int = {
    var result = -1
    if (nums.length == 1) nums(0)

    if (nums != null && nums.length != 0) {
      var left = 0
      var right = nums.length - 1
      if (nums(right) > nums(0)) {
        result = nums(0)
      } else {
        breakable {
          while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums(mid) > nums(mid + 1)) {
              result = nums(mid + 1)
              break()
            }
            if (nums(mid - 1) > nums(mid)) {
              result = nums(mid)
              break()
            }
            //左侧有序
            if (nums(mid) >= nums(0)) {
              right = mid - 1
              //右侧有序
            } else {
              left = mid + 1
            }
          }
        }

      }
    }
    result
  }

  /**
    *
    * @param nums
    * @return
    */
  def findMin2(nums: Array[Int]): Int = {
    var left = 0
    var right = nums.length - 1
    while (left < right) {
      val mid = left + (right - left) / 2
      if (nums(mid) > nums(right)) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    nums(left)
  }
}
