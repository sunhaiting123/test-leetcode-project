package secondary.string

import java.util

/**
  *
  * @description: 3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
  * @author: sunhaiting
  * @create: 2019-11-05 20:26
  **/
object LengthOfLongestSubstring {
  def main(args: Array[String]): Unit = {
    val s = "abcdabcbb"
    val len = LengthOfLongestSubstring(s)
    println(len)

    val len2 = LengthOfLongestSubstring2(s)
    println(len2)
    val len3 = LengthOfLongestSubstring3(s)
    println(len3)
  }


  /**
    * 输入: "abcabcbb"
    * 输出: 3
    * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    *
    * 时间复杂度：O(n3)
    *
    * @param s
    * @return
    */
  def LengthOfLongestSubstring(s: String): Int = {

    var ans = 0
    for (i <- 0 until s.length) {
      for (j <- i + 1 until s.length) {
        if (allUnique(s, i, j)) {
          ans = Math.max(ans, j - i)
        }
      }
    }
    ans
  }

  def allUnique(s: String, start: Int, end: Int): Boolean = {
    var bool = true
    val set = new util.HashSet[Character]()
    for (k <- start until end) {
      val char = s.charAt(k)
      if (set.contains(char)) {
        bool = false
      }
      set.add(char)
    }
    bool
  }

  /**
    * 滑动窗口 abcabcbb
    * abc
    * bca
    * cab
    * abc
    * bc
    * 时间复杂度O(2n)=O(n)
    *
    * @param s
    * @return
    */
  def LengthOfLongestSubstring2(s: String): Int = {

    val set = new util.HashSet[Character]()
    val n = s.length
    var i = 0
    var j = 0
    var ans = 0
    while (i < n && j < n) {
      if (!set.contains(s(j))) {
        set.add(s(j))
        j = j + 1
        ans = Math.max(ans, j - i)
      } else {
        set.remove(s(i))
        i = i + 1
      }
    }
    ans

  }

  /**
    * 优化后的滑动窗口
    * 时间复杂度：O(n)
    *
    * @param s
    * @return
    */
  def LengthOfLongestSubstring3(s: String): Int = {
    var ans = 0
    val map = new util.HashMap[Character, Int]()
    var i = 0
    for (j <- 0 until s.length) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i)
      }

      ans = Math.max(ans, j - i + 1)
      map.put(s.charAt(j), j + 1)
    }
    ans
  }
}
