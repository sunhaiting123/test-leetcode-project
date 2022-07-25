package simple

import java.util

/**
  *
  * @description: 217. 存在重复元素
  * @author: sunhaiting
  * @create: 2019-11-26 19:55
  **/
object TwohundredAndSeventeenContainsDuplicate {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 1,3, 1)
    val bool = containsDuplicate2(nums)
    println(bool)
  }

  /**
    * 排序方法
    * 输入: [1,2,3,1]
    * 输出: true
    * 时间复杂度 : O(nlog⁡n)。
    *
    * @param nums
    * @return
    */
  def containsDuplicate(nums: Array[Int]): Boolean = {
    var flag = false
    util.Arrays.sort(nums)
    for (i <- 0 until nums.length) {
      if (nums(i) == nums(i + 1)) flag = true
    }
    flag
  }

  /**
    * hash方式
    * 时间复杂度 : O(n)。
    *
    * @param nums
    * @return
    */
  def containsDuplicate2(nums: Array[Int]): Boolean = {
    var result = false
    val set = new util.HashSet[Int]()
    for (num <- nums; if (!result)) {
      if (set.contains(num)) {
        result = true
      } else {
        set.add(num)
      }
    }
    result
  }


}
