package secondary.string

import scala.collection.mutable.HashSet

/**
  *
  * @description: 3. 无重复字符的最长子串
  *               给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
  * @author: sunhaiting
  * @create: 2020-03-04 15:34
  **/
object ThreeLengthOfLongestSubstring {
  def main(args: Array[String]): Unit = {
  val s = "abcdeded"
    val i = lengthOfLongestSubstring(s)
    println(i)
  }

  /**
    *
    * @param s
    * @return
    */
  def lengthOfLongestSubstring(s: String): Int = {
    val set = new HashSet[Char]()

    var j = 0
    var i = 0
    var result = 0
    while (i < s.length && j < s.length) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j))
        j = j + 1
        result = math.max(result, j - i)
      } else {
        set.remove(s.charAt(i))
        i = i + 1
      }
    }
    result
  }
}
