package simple.string

import java.util

/**
  *
  * @description: 387. 字符串中的第一个唯一字符
  *               给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
  * @author: sunhaiting
  * @create: 2020-01-29 20:28
  **/
object ThreeHundredAndEightySevenFirstUniqChar {
  def main(args: Array[String]): Unit = {
    val str = "leetcode"
    val i = firstUniqChar(str)
    println(i)
  }

  /**
    *
    * @param s
    * @return
    */
  def firstUniqChar(s: String): Int = {
    val map = new util.HashMap[Char, Int]()
    var result = -1
    val length = s.length
    for (i <- 0 until length) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1)
    }

    for (i <- 0 until length; if (result == -1)) {
      if (map.get(s.charAt(i)) == 1) {
        result = i
      }
    }
    result
  }
}
