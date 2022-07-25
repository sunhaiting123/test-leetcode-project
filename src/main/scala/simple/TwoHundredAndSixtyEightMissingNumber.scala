package simple


/**
  *
  * @description: 268:给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
  * @author: sunhaiting
  * @create: 2020-01-13 16:15
  **/
object TwoHundredAndSixtyEightMissingNumber {
  def main(args: Array[String]): Unit = {

    val arr = Array(9, 6, 4, 2, 3, 5, 7, 0, 1)
    val i = missingNumber3(arr)
    println(i)

  }

  /**
    * 输入: [9,6,4,2,3,5,7,0,1]
    * 输出: 8
    * 用数学求和方式计算
    *
    * @param nums
    * @return
    */
  def missingNumber(nums: Array[Int]): Int = {
    val length = nums.length
    val sum1 = length * (length + 1) / 2
    var sum2 = 0
    for (num <- nums) {
      sum2 += num
    }
    sum1 - sum2

  }

  /**
    * 使用hashSet方式
    *
    * @param nums
    * @return
    */
  def missingNumber2(nums: Array[Int]): Int = {
    var result = -1
    val set = new java.util.HashSet[Int]()
    for (num <- nums) {
      set.add(num)
    }
    var flag = true
    for (num <- 0 until nums.length ; if (flag)) {
      if (!set.contains(num)) {
        result = num
        flag = false
      }
    }

    result
  }

  /**
    * 使用位运算
    * 由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，
    * 因此我们可以通过异或运算找到缺失的数字。
    *
    * @param nums
    * @return
    */
  def missingNumber3(nums: Array[Int]): Int = {

    var result = nums.length
    for (i <- 0 until nums.length) {
      result = result ^ (i ^ nums(i))
    }
    result
  }


}
