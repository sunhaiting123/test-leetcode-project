package simple.string

import scala.collection.mutable

/**
  *
  * @description: 409. 最长回文串
  *               给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
  *               在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
  * @author: sunhaiting
  * @create: 2020-02-17 17:27
  **/
object FourHundredAndNineLongestPalindrome {
  def main(args: Array[String]): Unit = {
    val s = "abccccdd"
    val i = longestPalindrome2(s)
    println(i)
  }

  /**
    * 使用ASCII表方式
    *
    * @param s
    * @return
    */
  def longestPalindrome(s: String): Int = {

    val arr = new Array[Int](58)
    //对于字符串中的每一个字符，在数组中值变为1，没有的字符为0
    for (i <- 0 until s.length) {
      arr(s.charAt(i) - 'A') = arr(s.charAt(i) - 'A') + 1
    }

    var count = 0

    for (num <- arr) {
      count = count + num / 2 * 2
      //如果字符个数为奇数，在计算count最后加上1
      if (num % 2 == 1 && count % 2 == 0) {
        count = count + 1
      }
    }
    count
  }

  /**
    * 借助map来实现
    *
    * @param s
    * @return
    */
  def longestPalindrome2(s: String): Int = {

    val map = new mutable.HashMap[Char, Int]()
    for (char <- s.toCharArray) {
      map.put(char, map.getOrElse(char, 0) + 1)
    }
    var count = 0

    for (num <- map.values) {
      count = count + num / 2 * 2
      //如果字符个数为奇数，在计算count最后加上1
      if (num % 2 == 1 && count % 2 == 0) {
        count = count + 1
      }
    }
    count
  }
}
