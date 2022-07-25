package simple

import java.util

/**
  *
  * @description: 204. 计数质数,统计所有小于非负整数 n 的质数的数量。
  * @author: sunhaiting
  * @create: 2019-11-26 16:50
  **/
object TwohundredAndFourCountPrimes {
  def main(args: Array[String]): Unit = {
    val i = countPrimes2(10)
    println(i)
  }

  /**
    * 输入: 10
    * 输出: 4
    * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    *
    * @param n
    * @return
    */
  def countPrimes(n: Int): Int = {
    var count = 0
    for (i <- 2 to n) {
      if (isPrime(i)) {
        count = count + 1
      }
    }
    count
  }

  def isPrime(n: Int): Boolean = {
    var flag = true
    //    for (i <- 2 to n) {
    //向上取整
    val s = Math.ceil(Math.sqrt(n)).toInt
    for (i <- 2 to s) {
      if (n % i == 0) flag = false
    }
    flag
  }

  /**
    * 厄拉多塞筛法：
    * @param n
    * @return
    */
  def countPrimes2(n: Int): Int = {
    val isPrim = new Array[Boolean](n)
    util.Arrays.fill(isPrim, true)
    val s = Math.ceil(Math.sqrt(n)).toInt
    for (i <- 2 to s) {
      //如果当前i是质数
      if (isPrim(i)) {
        //遍历i的倍数，将对应的数组中的值变为false(因为i的倍数不是质数)
        for (j <- Range(i * i, n, i)) {
          isPrim(j) = false
        }
      }
    }
    var count = 0
    for (i <- 2 until n) {
      if (isPrim(i))
        count = count + 1
    }
    count
  }
}
