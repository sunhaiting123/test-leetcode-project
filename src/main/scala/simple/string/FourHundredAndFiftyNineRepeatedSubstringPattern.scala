package simple.string

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description:
  * @author: sunhaiting
  * @create: 2020-02-28 21:51
  **/
object FourHundredAndFiftyNineRepeatedSubstringPattern {
  def main(args: Array[String]): Unit = {
    val s = "abcabcabc"
    val bool = repeatedSubstringPattern(s)
    println(bool)
  }

  /**
    *
    * @param s
    * @return
    */
  def repeatedSubstringPattern(s: String): Boolean = {
    var flag = true
    var result = false
    if (s == null) {
      flag = false
    }
    //长度为1不能拆分子串
    else if (s.length == 1) {
      flag = false
    }
    //长度大于1，判断是否所有字符都相同
    else if (s.split(s.charAt(0).toString).length == 0) {
      result = true
      flag = false
    }
    breakable(
      for (i <- (2 until s.length - 1).reverse; if (flag)) {
        if (s.length % i == 0) {
          val subStr = s.substring(0, i)
          val strings = s.split(subStr)
          if (strings.length == 0) {
            result = true
            break()
          }
        }
      }
    )
    result
  }
}
