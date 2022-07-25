package secondary.num

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 16. 最接近的三数之和
  *               给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
  *               找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
  *               假定每组输入只存在唯一答案。
  *
  * @author: sunhaiting
  * @create: 2020-03-09 10:53
  **/
object SixteenThreeSumClosest {
  def main(args: Array[String]): Unit = {

    val arr = Array(-1,2,1,-4)
    val i = threeSumClosest(arr,1)
    println(i)

  }

  /**
    * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
    * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
    *
    *
    * @param nums
    * @param target
    * @return
    */
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val nums1 = nums.sorted
    var ans = nums1(0) + nums1(1) + nums1(2)
    breakable {
      for (i <- 0 until nums1.length) {
        var j = i + 1
        var k = nums1.length - 1
        while (j < k) {
          val sum = nums1(i) + nums1(j) + nums1(k)
          if (math.abs(sum - target) < math.abs(ans - target)) {
            ans = sum
          }
          if (sum > target) {
            k = k - 1
          } else if (sum < target) {
            j = j + 1
          } else {
            break()
          }
        }
      }
    }
    ans
  }
}
