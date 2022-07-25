package simple

import java.util

import scala.collection.mutable

/**
  *
  * @description: 169.给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
  * @author: sunhaiting
  * @create: 2019-11-21 19:40
  **/
object OnehundredAndSixtyNineEmajorityElement {
  def main(args: Array[String]): Unit = {
    //    val arr = Array(2, 2, 1, 1, 1, 2, 2)
    val arr = Array(2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1)
    val result = majorityElement(arr)
    println(result)
  }

  /**
    * 你可以假设数组是非空的，并且给定的数组总是存在众数。
    *
    * 示例 1:
    *
    * 输入: [3,2,3]
    * 输出: 3
    *
    * 示例 2:
    *
    * 输入: [2,2,1,1,1,2,2]
    * 输出: 2
    *
    *
    * hash表方式
    * 时间复杂度：O(n)
    * 空间复杂度：O(n)
    *
    *
    * @param nums
    * @return
    */
  def majorityElement(nums: Array[Int]): Int = {

    val map = new util.HashMap[Int, Int]()

    for (num <- nums) {
      val i = map.getOrDefault(num, 0)
      map.put(num, i + 1)
    }
    val keySet: util.Set[Int] = map.keySet()
    var maxKey = 0
    var maxValue = 0
    val it = keySet.iterator()
    while (it.hasNext) {
      val key = it.next()
      if (map.get(key) > maxValue) {
        maxKey = key
        maxValue = map.get(key)
      }
    }
    maxKey

  }


  /**
    * 排序
    *
    * 时间复杂度：O(nlgn)
    * 用 Python 和 Java 将数组排序开销都为 O(nlgn) ，它占据了运行的主要时间。
    * 空间复杂度：O(1) 或者 O(n)
    * 我们将 nums 就地排序，如果不能就低排序，我们必须使用线性空间将 nums 数组拷贝，然后再排序。
    *
    *
    * @param nums
    * @return
    */
  def majorityElement2(nums: Array[Int]): Int = {
    util.Arrays.sort(nums)
    nums(nums.length / 2)
  }

  /**
    * Boyer-Moore 投票算法
    * 如果我们把众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，显然和大于 0 ，
    * 从结果本身我们可以看出众数比其他数多。
    *
    *
    * 时间复杂度：O(n)
    * Boyer-Moore 算法严格执行了 n 次循环，所以时间复杂度是线性时间的。
    * 空间复杂度：O(1)
    * Boyer-Moore 只需要常数级别的额外空间。
    *
    *
    * @param nums
    * @return
    */
  def majorityElement3(nums: Array[Int]): Int = {

    var count = 0
    var candidate = 0
    for (num <- nums) {
      if (count == 0) {
        candidate = num
      }
      if (num == candidate) {
        count = count + 1
      } else {
        count = count - 1
      }
    }
    candidate
  }


}
