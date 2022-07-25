package secondary.array

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  *
  * @description: 46. 全排列
  *               给定一个没有重复数字的序列，返回其所有可能的全排列。
  * @author: sunhaiting
  * @create: 2020-03-15 11:46
  **/
object FortySixPermute {
  def main(args: Array[String]): Unit = {

    val nums = Array[Int](1, 2, 3)
    val list = permute(nums)
    println(list.toBuffer)
  }


  /**
    *
    * @param nums
    * @return
    */

  def permute(nums: Array[Int]): List[List[Int]] = {

    val len = nums.length
    // 使用一个动态数组保存所有可能的全排列
    val res = new mutable.ArrayBuffer[mutable.ArrayBuffer[Int]]()

    if (len == 0) res.map(_.toList).toList
    else {
      val path = new ArrayBuffer[Int]()
      val used = new Array[Boolean](len)
      dfs(nums, 0, len, path, used, res)
      res.map(_.toList).toList
    }
  }

  def dfs(nums: Array[Int], depth: Int, len: Int, path: ArrayBuffer[Int], used: Array[Boolean], res: mutable.ArrayBuffer[mutable.ArrayBuffer[Int]]): Unit = {

    var flag = true
    if (depth == len) {
      val s = new ArrayBuffer[Int]
      s.++=(path)
      res.append(s)
      flag = false
    }

    for (i <- 0 until len; if (flag)) {
      if (!used(i)) {
        path.append(nums(i))
        used(i) = true
        dfs(nums, depth + 1, len, path, used, res)
        // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
        used(i) = false
        path.remove(path.length - 1)
      }
    }
  }
}
