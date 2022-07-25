package simple

import java.util

/**
  *
  * @description: 给定一个整数数组 nums 和一个目标值 target，
  *               请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
  * @author: sunhaiting
  * @create: 2019-11-05 19:51
  **/
object TwoSum {

  def main(args: Array[String]): Unit = {
    val nums = Array[Int](2, 7, 11, 15)
    val target = 9
    val result = twoSum(nums, target)
    println(result)

    val time1 = System.currentTimeMillis()
    val result2 = twoSumQuick(nums, target)
    val time2 = System.currentTimeMillis()
    println(result2, time2 - time1)
  }


  /**
    * 给定 nums = [2, 7, 11, 15], target = 9
    * *
    * * 因为 nums[0] + nums[1] = 2 + 7 = 9
    * * 所以返回 [0, 1]
    *
    * @param array
    * @param target
    */
  def twoSum(array: Array[Int], target: Int): util.ArrayList[Int] = {
    val result = new util.ArrayList[Int]()
    for (i <- 0 until array.length) {
      for (j <- i until array.length) {
        if (array(i) + array(j) == target) {
          result.add(i)
          result.add(j)
        }
      }

    }
    result
  }

  /**
    * 建立k-v ，一一对应的哈希表
    *
    * @param array
    * @param target
    * @return
    */
  def twoSumQuick(array: Array[Int], target: Int): util.ArrayList[Int] = {
    // 建立k-v ，一一对应的哈希表
    //HashMap[Integer, Integer] ,第一个Int是数组中的数，第二个Int是数组索引
    val hash = new util.HashMap[Integer, Integer]()
    val indexs = new util.ArrayList[Int]()
    for (i <- 0 until array.length) {
      if (hash.containsKey(array(i))) {
        indexs.add(i)
        indexs.add(hash.get(array(i)))
      }
      // 将数据存入 key为补数 ，value为下标
      hash.put(target - array(i), i)
    }
    indexs
  }

}
