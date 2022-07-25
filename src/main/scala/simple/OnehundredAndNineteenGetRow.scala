package simple

import java.util

/**
  *
  * @description: 119.给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
  * @author: sunhaiting
  * @create: 2019-11-19 19:32
  **/
object OnehundredAndNineteenGetRow {
  def main(args: Array[String]): Unit = {
    val ints = getRow(5)
    println(ints.toArray.toBuffer)
  }

  /**
    * 杨辉三角的第 k 行等价于，二项式 (x + y)k 的系数。
    * Cnk​=n!/(k!(n−k)!)=(n∗(n−1)∗(n−2)∗...(n−k+1))/k!
    *
    * @param rowIndex
    * @return
    */
  def getRow(rowIndex: Int): util.ArrayList[Int] = {
    val list = new util.ArrayList[Int]()
    val n = rowIndex
    for (k <- 0 to  n) {
      list.add(combination(n, k))
    }
    list
  }

  def combination(n: Int, k: Int): Int = {
    var res = 1
    for (i <- 1 to k) {
      res = res * (n - k + i) / i
    }
    res

  }
}
