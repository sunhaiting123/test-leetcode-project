package simple.num


import scala.collection.mutable

/**
  *
  * @description: 415. 字符串相加
  *               给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
  * @author: sunhaiting
  * @create: 2020-02-18 17:26
  **/
object FourHundredAndFifteenAddStrings {
  def main(args: Array[String]): Unit = {

    val num1 = "99"
    val num2 = "100"

    val str = subtractStrings(num1, num2)
    println(str)
  }

  /**
    * 字符串相加
    *
    * @param num1
    * @param num2
    * @return
    */
  def addStrings(num1: String, num2: String): String = {
    val str = new StringBuilder("")
    var i = num1.length - 1
    var j = num2.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
      val n1 = if (i >= 0) {
        num1.charAt(i) - '0'
      } else {
        0
      }
      val n2 = if (j >= 0) {
        num2.charAt(j) - '0'
      } else {
        0
      }
      val tmp = n1 + n2 + carry
      carry = tmp / 10
      str.append(tmp % 10)
      i = i - 1
      j = j - 1
    }
    if (carry == 1) str.append(1)
    str.reverse.toString()
  }

  /**
    * 字符串相减
    *
    * @param num1
    * @param num2
    * @return
    */
  def subtractStrings(num1: String, num2: String): String = {
    if (ifNot(num1, num2)) {
      sss(num1, num2)
    } else {
      val str = sss(num2, num1)
      "-"+str
    }
  }

  /**
    * 判断num1和num2的大小
    *
    * @param s
    * @param t
    * @return
    */
  def ifNot(s: String, t: String): Boolean = {
    var flag = true
    if (s.length() < t.length()) {
      flag = false
    } else if (s.length() == t.length()) {
      for (i <- 0 until s.length(); if (flag)) {
        if ((s.charAt(i) - t.charAt(i)) < 0)
          flag = false
      }
    }
    flag
  }


  def sss(num1: String, num2: String): String = {
    var i = num1.length - 1
    var j = num2.length - 1
    var carry = 0
    val result = new mutable.StringBuilder("")
    while (i >= 0 || j >= 0) {
      val n1 = if (i >= 0) {
        num1.charAt(i) - '0'
      } else {
        0
      }
      val n2 = if (j >= 0) {
        num2.charAt(j) - '0'
      } else {
        0
      }
      var tmp = n1 - n2 + carry
      if (tmp < 0) {
        tmp = tmp + 10
        carry = -1
      } else {
        carry = 0
      }
      result.append(tmp % 10)
      i = i - 1
      j = j - 1

    }
    var rrr = result.reverse.toString()
    //判断结果是否全为0
    if (rrr.replaceAll("0", "").length == 0) {
      rrr = "0"
    } else {
      var t = 0
      while (rrr.charAt(t) == '0') {
        t = t + 1
      }
      rrr = rrr.substring(t)
    }
    rrr
  }
}
