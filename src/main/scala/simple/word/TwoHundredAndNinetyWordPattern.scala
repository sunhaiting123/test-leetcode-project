package simple.word

import java.util

/**
  *
  * @description: 290. 单词规律
  *               给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
  *               这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
  * @author: sunhaiting
  * @create: 2020-01-14 11:01
  **/
object TwoHundredAndNinetyWordPattern {
  def main(args: Array[String]): Unit = {
    val pattern = "abba"
    val str = "dog cat cat dog"
    println(pattern.length,str.split(" ").length)
    val bool = wordPattern(pattern,str)
    println(bool)

  }

  /**
    *
    * 输入: pattern = "abba", str = "dog cat cat dog"
    * 输出: true
    *
    * @param pattern
    * @param str
    * @return
    */
  def wordPattern(pattern: String, str: String): Boolean = {
    var flag = true
    val arr = str.split(" ")
    val map = new util.HashMap[Char, String]()
    if (pattern.length != arr.length) {
      flag = false
    } else {
      for (i <- 0 until pattern.length; if (flag)) {
        val key = pattern.charAt(i)
        if (!map.containsKey(key)) {
          map.put(key, arr(i))
        } else {
          if (map.get(key) != arr(i)) {
            flag = false
          }
        }
      }
    }
    flag
  }
}
