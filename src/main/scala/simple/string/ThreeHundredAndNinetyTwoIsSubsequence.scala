package simple.string

/**
  *
  * @description: 392. 判断子序列
  *               给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
  *               你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
  *               字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
  *               （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
  * @author: sunhaiting
  * @create: 2020-01-29 22:30
  **/
object ThreeHundredAndNinetyTwoIsSubsequence {
  def main(args: Array[String]): Unit = {
    val s = "axc"
    val t = "ahbgdc"
    val bool = isSubsequence2(s, t)
    println(bool)
  }

  /**
    * 使用indexof方法
    * 定义一个index变量表示找到s字符串变量中第index个字符，
    * i变量是表示从t中的哪一个索引开始找
    *
    * @param s
    * @param t
    * @return
    */
  def isSubsequence(s: String, t: String): Boolean = {
    var index = 0
    var i = 0
    while (index < s.length && t.indexOf(s.charAt(index), i) >= i) {
      i = t.indexOf(s.charAt(index), i) + 1
      index = index + 1

    }

    index == s.length
  }

  /**
    * 双指针方法
    *
    * @param s
    * @param t
    * @return
    */
  def isSubsequence2(s: String, t: String): Boolean = {
    var index = 0
    var i = 0
    import scala.util.control.Breaks._
    breakable {
      while (i < s.length) {
        var j = index
        breakable {
          while (j < t.length) {
            if (s.charAt(i) == t.charAt(j)) {
              i = i + 1
              j = j + 1
              break()
            } else {
              j = j + 1
            }
          }
        }
        index = j
        if (j == t.length) {
          break()
        }
      }
    }
    i == s.length
  }
}
