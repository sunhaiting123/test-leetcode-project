package simple

/**
  *
  * @description:
  * 53:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
  * @author: sunhaiting
  * @create: 2019-11-11 14:36
  **/
object FiftyThreeMaxSubArray {
  def main(args: Array[String]): Unit = {

  }

  /**
    * 输入: [-2,1,-3,4,-1,2,1,-5,4],
    * 输出: 6
    * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    *
    * 时间复杂度 O(n2)，空间复杂度 O(n)
    *
    * @param nums
    * @return
    */
  def maxSubArray(nums: Array[Int]): Int = {

    var sum = nums(0)
    for (i <- 0 until nums.length) {
      var tmp = 0
      for (j <- i until nums.length) {
        tmp = tmp + nums(j)
        if (tmp > sum) {
          sum = tmp
        }
      }
    }
    sum
  }

  /**
    * 动态规划
    *
    * @param nums
    * @return
    */
  def maxSubArray2(nums: Array[Int]): Int = {

    var tmp = nums(0)
    var sum = tmp
    for (j <- 1 until nums.length) {
      // 当当前序列加上此时的元素的值大于tmp的值，说明最大序列和可能出现在后续序列中，记录此时的最大值
      if (tmp > 0) {
        tmp = tmp + nums(j)
        sum = Math.max(sum, tmp)
      } else {
        //  当tmp(当前和)小于下一个元素时，当前最长序列到此为止。以该元素为起点继续找最大子序列,
        //  并记录此时的最大值
        tmp = nums(j)
        sum = Math.max(sum, tmp)
      }
    }
    sum
  }

  /**
    * 分治法 (见java版本)
    *
    * @param nums
    * @return
    */
  def maxSubArray3(nums: Array[Int]): Int = {


    0
  }


}
