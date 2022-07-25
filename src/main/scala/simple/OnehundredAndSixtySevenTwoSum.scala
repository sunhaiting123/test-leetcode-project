package simple

import java.util

/**
  *
  * @description: 167.给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
  * @author: sunhaiting
  * @create: 2019-11-20 20:54
  **/
object OnehundredAndSixtySevenTwoSum {
  def main(args: Array[String]): Unit = {

    val arr = Array(2, 7, 11, 15)
    val target = 9
    val ints = twoSum(arr, target)
    println(ints.toArray().toBuffer)


  }

  /**
    * 双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
    * 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
    * 输入: numbers = [2, 7, 11, 15], target = 9
    * 输出: [1,2]
    * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
    *
    * @param numbers
    * @param target
    * @return
    */
  def twoSum(numbers: Array[Int], target: Int): util.ArrayList[Int] = {
    val arr = new util.ArrayList[Int]()
    var i = 0
    var j = numbers.length - 1
    var flag = true
    while (i < j && flag) {
      if (numbers(i) + numbers(j) == target) {
        arr.add(i+1)
        arr.add(j+1)
        flag = false
      } else if (numbers(i) + numbers(j) > target) {
        j = j - 1
      } else {
        i = i + 1
      }
    }
    arr
  }

}
