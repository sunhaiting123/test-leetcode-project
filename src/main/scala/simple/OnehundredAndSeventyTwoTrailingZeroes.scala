package simple

/**
  *
  * @description: 172.给定一个整数 n，返回 n! 结果尾数中零的数量。
  * @author: sunhaiting
  * @create: 2019-11-22 15:50
  **/
object OnehundredAndSeventyTwoTrailingZeroes {
  def main(args: Array[String]): Unit = {
    //        val i = trailingZeroes(15)
    val i = trailingZeroes3(15)
    println(i)
  }

  /**
    * 输入: 5
    * 输出: 1
    * 解释: 5! = 120, 尾数中有 1 个零.
    *
    * @param n
    * @return
    */
  def trailingZeroes(n: Int): Int = {
    var num = 1l
    for (i <- 1 to n) {
      num = num * i
    }
    println(num)
    var count = 0
    while (num % 10 == 0) {
      count = count + 1
      num = num / 10
    }
    count
  }

  /**
    * 计算N的阶乘(N!=1*2*...*N)有多少个后缀0，即计算N!里有多少个10，
    * 也就是计算N!里有多少个2和5（数学原理：分解质因数），最后结果即2的个数和5的个数取较小值。
    * 时间复杂度为O(NlogN)
    *
    * @param n
    * @return
    */
  def trailingZeroes2(n: Int): Int = {
    var count1 = 0
    var count2 = 0
    for (i <- 2 to n) {
      var value = i
      while (value % 2 == 0) {
        count1 += 1
        value = value / 2
      }
      while (value % 5 == 0) {
        count2 += 1
        value = value / 5
      }
    }
    Math.min(count1, count2)
  }

  /**
    * N!质因数里2的个数总是要比5的个数多，因此此题就变成了求解N!里有多少个质因数5
    * N!有多少个后缀0，即N!有多少个质因数5。
    *
    * @param n
    * @return
    */
  def trailingZeroes3(n: Int): Int = {
    var count1 = 0
    for (i <- 2 to n) {
      var value = i
      while (value % 5 == 0) {
        count1 += 1
        value = value / 5
      }
    }
    count1
  }


}
