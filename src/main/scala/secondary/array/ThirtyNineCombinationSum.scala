package secondary.array

import java.util

import scala.util.control.Breaks.{break, breakable}
import scala.collection.mutable.ListBuffer

/**
  *
  * @description:  39. 组合总和
  * @author: sunhaiting
  * @create: 2020-03-13 16:57
  **/
object ThirtyNineCombinationSum {
  def main(args: Array[String]): Unit = {

    val arr = Array(2,3,6,7)
    val list = combinationSum(arr,7)
    println(list.toBuffer)
  }

  var res = new util.LinkedList[util.LinkedList[Int]]()

  /**
    *
    * @param candidates
    * @param target
    * @return
    */
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {

    val list = new util.LinkedList[Int]()
    val nums = candidates.sorted
    dfs(nums, target, 0, list)

    import scala.collection.JavaConverters._
    val listBuffer = new ListBuffer[List[Int]]()
    for (i <- 0 until res.size()) {
      val value: List[Int] = res.get(i).asScala.toList
      listBuffer.append(value)
    }
    listBuffer.toList

  }

  def dfs(nums: Array[Int], target: Int, start: Int, list: util.LinkedList[Int]): Unit = {

    if (target < 0) return
    if (target == 0) {
      res.add(new util.LinkedList[Int](list))
      return
    }
    breakable {
      for (i <- start until nums.length) {
        if (target < nums(i)) {
          break()
        }
        list.add(nums(i))
        dfs(nums, i, target - nums(i), list)
        list.removeLast()
      }
    }
  }


}
