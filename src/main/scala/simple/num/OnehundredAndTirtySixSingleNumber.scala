package simple.num

import scala.collection.mutable

/**
  *
  * @description: 136:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
  *               找出那个只出现了一次的元素。
  * @author: sunhaiting
  * @create: 2019-11-20 16:05
  **/
object OnehundredAndTirtySixSingleNumber {
  def main(args: Array[String]): Unit = {
    val nums = Array(4, 1, 2, 1, 2)
    val i = singleNumber2(nums)
    println(i)
  }

  /**
    * 利用hash表
    * 输入: [4,1,2,1,2]
    * 输出: 4
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Int = {
    val map = new mutable.HashMap[Int, Int]()
    var result = -1
    for (i <- nums) {
      var count: Int = map.getOrElse(i, 0)
      count = count + 1
      map.put(i, count)
    }
    val keys: Set[Int] = map.keySet.toSet
    for (i <- keys) {
      val count = map.getOrElse(i, 0)
      if (count == 1) {
        result = i
      }
    }
    result
  }

  /**
    * 异或方法
    *
    * @param nums
    * @return
    */
  def singleNumber2(nums: Array[Int]): Int = {
    var result = nums(0)
    for (i <- 1 until nums.length) {
      result = result ^ nums(i)
    }
    result

  }

}
