package secondary.array


import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 47. 全排列 II
  *               给定一个可包含重复数字的序列，返回所有不重复的全排列。
  * @author: sunhaiting
  * @create: 2020-03-15 17:29
  **/
object FortySevenPermuteUnique {
  def main(args: Array[String]): Unit = {

    val nums = Array(1,1,2)
    val list = permuteUnique(nums)
    println(list.toBuffer)
  }


  /**
    *
    * @param nums
    * @return
    */
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    val len = nums.length
    // 使用一个动态数组保存所有可能的全排列
    val res = new mutable.ArrayBuffer[mutable.ArrayBuffer[Int]]()
    if (len == 0) res.map(_.toList).toList
    else {
      val sortedNums = nums.sorted
      val path = new ArrayBuffer[Int]()
      val used = new Array[Boolean](len)
      dfs(sortedNums, 0, len, path, used, res)
      res.map(_.toList).toList
    }
  }


  def dfs(nums: Array[Int], depth: Int, len: Int, path: ArrayBuffer[Int], used: Array[Boolean], res: ArrayBuffer[ArrayBuffer[Int]]): Unit = {

    var flag = true
    if (depth == len) {
      val s = new ArrayBuffer[Int]()
      s.++=(path)
      res.append(s)
      flag = false
    }

    for (i <- 0 until len; if (flag)) {
      breakable {
        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        if ((i > 0 &&  !used(i-1) && nums(i) == nums(i - 1)) || (used(i)) ) break()
        path.append(nums(i))
        used(i) = true
        dfs(nums, depth + 1, len, path, used, res)
        used(i) = false
        path.remove(path.length - 1)
      }
    }
  }

}
