package secondary.string

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 5. 最长回文子串
  *               给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
  * @author: sunhaiting
  * @create: 2020-03-05 17:10
  **/
object FiveLongestPalindrome {
  def main(args: Array[String]): Unit = {
    val s = "abbc"
    val str = longestPalindrome2(s)
    println(str)
  }

  /**
    *
    * @param s
    * @return
    */
  def longestPalindrome2(s: String): String = {
    if (s == null || s.length == 0) {
      null
    } else {
      var maxStr = ""
      val n = s.length
      //数组左闭右开i == j || i + 1 == j表示空字符或者单个字符肯定是回文串
      val bool = Array.ofDim[Boolean](n + 1, n + 1)
      for (j <- 0 until n + 1) {
        for (i <- j to 0 by -1) {
          if (i == j || i + 1 == j) {
            bool(i)(j) = true
            //判断头和尾是否相等，并且判断头后一个到尾的前一个是否相等
          } else if (s.charAt(i) == s.charAt(j - 1) && bool(i + 1)(j - 1)) {
            bool(i)(j) = true
          }
          if (i != j && bool(i)(j) && maxStr.length < j - i) {
            maxStr = s.substring(i, j)
          }

        }
      }
      maxStr
    }
  }


  def longestPalindrome3(s: String): String = {
    val n = s.length
    var res = ""
    val dp = Array.ofDim[Boolean](n, n)
    for (i <- n - 1 to 0 by -1) {
      for (j <- i until n) {
        //j - i 代表长度减去 1
        if ((s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp(i + 1)(j - 1))) {
          dp(i)(j) = true
        }
        if (dp(i)(j) && j - i + 1 > res.length) {
          res = s.substring(i, j + 1)
        }
      }
    }
    res
  }


  /**
    * 输入: "babad"
    * 输出: "bab"
    * 注意: "aba" 也是一个有效答案。
    *
    * 暴力计算
    *
    * @param s
    * @return
    */
  def longestPalindrome(s: String): String = {
    if (s == null || s.length == 0) {
      null
    } else {
      val n = s.length
      var max = ""
      for (i <- 0 until n) {
        for (j <- i until n) {
          //substring 左闭右开
          if (isPalindrome(s.substring(i, j + 1)) && j - i + 1 > max.length) {
            max = s.substring(i, j + 1)
            println("============", max)
          }
        }
      }
      max
    }
  }

  def isPalindrome(s: String): Boolean = {
    val len = s.length()
    var flag = true
    breakable(
      for (i <- 0 to len / 2) {
        if (s.charAt(i) != s.charAt(len - i - 1)) {
          flag = false
          break()
        }
      }
    )
    flag
  }


}
