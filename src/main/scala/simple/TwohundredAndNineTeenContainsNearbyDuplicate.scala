package simple

import java.util

import scala.collection.mutable

/**
  *
  * @description: 219. 存在重复元素 II
  *               给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
  *               使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
  * @author: sunhaiting
  * @create: 2019-11-26 20:05
  **/
object TwohundredAndNineTeenContainsNearbyDuplicate {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 1)
    val k = 3
    val bool = containsNearbyDuplicate(nums, k)
    println(bool)
  }

  /**
    * 二叉搜索树
    * 输入: nums = [1,2,3,1], k = 3
    * 输出: true
    * 遍历数组，对于每个元素做以下操作：
    *
    * 在 二叉搜索树(BST) 中搜索当前元素，如果找到了就返回 true。
    * 在 BST 中插入当前元素。
    * 如果当前 BST 的大小超过了 k，删除当前 BST 中最旧的元素。
    * 时间复杂度：O(nlog⁡(min⁡(k,n)))
    *
    * @param nums
    * @param k
    * @return
    */
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    var flag = false
    val tree = new mutable.TreeSet[Int]()

    for (i <- 0 until nums.length ; if(!flag)) {
      if (tree.contains(nums(i))) {
        flag = true
      } else {
        tree.add(nums(i))
        if (tree.size > k) {
          tree.remove(nums(i - k))
        }
      }
    }
    flag
  }

  /**
    * 时间复杂度：O(n)
    * 遍历数组，对于每个元素做以下操作：
    *
    * 在散列表中搜索当前元素，如果找到了就返回 true。
    * 在散列表中插入当前元素。
    * 如果当前散列表的大小超过了 k， 删除散列表中最旧的元素。
    *
    * @param nums
    * @param k
    * @return
    */
  def containsNearbyDuplicate2(nums: Array[Int], k: Int): Boolean = {
    var flag = false
    val set = new util.HashSet[Int]()

    for (i <- 0 until nums.length; if (!flag)) {
      if (set.contains(nums(i))) {
        flag = true
      } else {
        set.add(nums(i))
        //处理数组中k之后的
        if (set.size > k) {
          set.remove(nums(i - k))
        }
      }
    }
    flag
  }


}
