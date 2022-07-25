package simple.array

/**
  *
  * @description: 485. 最大连续1的个数
  *               给定一个二进制数组， 计算其中最大连续1的个数。
  * @author: sunhaiting
  * @create: 2020-02-29 15:58
  **/
object FourHundredAndEightyFiveFindMaxConsecutiveOnes {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1)
    val i = findMaxConsecutiveOnes(arr)
    println(i)
  }

  /**
    * 示例 1:
    *
    * 输入: [1,1,0,1,1,1]
    * 输出: 3
    * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
    *
    * @param nums
    * @return
    */
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var count = 0
    var maxCount = 0

    for (i <- 0 until nums.length) {
      if (nums(i) == 1) {
        count = count + 1
      } else {
        maxCount = math.max(count, maxCount)
        count = 0
      }
    }

    math.max(count, maxCount)
  }
}
