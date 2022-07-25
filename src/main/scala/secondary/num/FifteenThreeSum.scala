package secondary.num

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 15. 三数之和
  *               给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
  *               使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
  *               注意：答案中不可以包含重复的三元组。
  * @author: sunhaiting
  * @create: 2020-03-08 21:47
  **/
object FifteenThreeSum {
  def main(args: Array[String]): Unit = {

    //    val arr = Array(-1, 0, 1, 2, -1, -4,-4)
    val arr = Array(0, 0, 0, 0, 0)
    val list = threeSum(arr)
    println(list.toBuffer)
  }

  /**
    *
    * @param nums
    * @return
    */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.length < 3) {
      null
    } else {
      val list = new ListBuffer[ListBuffer[Int]]()
      val nums1 = nums.sorted
      var flag = true
      for (i <- 0 until nums1.length; if (flag)) {
        if (nums1(i) > 0) {
          flag = false
        }
        breakable {
          //如果当前的值和上一个值相同，跳出本次循环,去重
          if (i > 0 && nums1(i) == nums1(i - 1)) {
            break()
          }
          //双指针j,k
          var j = i + 1
          var k = nums1.length - 1
          val target = -nums1(i)
          while (j < k) {
            if (nums1(j) + nums1(k) == target) {
              val curr = new ListBuffer[Int]()
              curr.append(nums1(i))
              curr.append(nums1(j))
              curr.append(nums1(k))
              list.append(curr)

              //当左右两个值相等，去重
              while (j < k && nums1(j) == nums1(j + 1)) j = j + 1
              while (k > j && nums1(k) == nums1(k - 1)) k = k - 1
              k = k - 1
              j = j + 1

            } else if (nums1(j) + nums1(k) > target) {
              k = k - 1
            } else {
              j = j + 1
            }
          }
        }
      }
      val result: List[List[Int]] = list.map(_.toList).toList
      result
    }
  }
}
