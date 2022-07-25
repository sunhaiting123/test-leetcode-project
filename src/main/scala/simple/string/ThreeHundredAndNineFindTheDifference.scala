package simple.string

import java.util

/**
  *
  * @description: 389. 找不同（和136题类似）
  *               给定两个字符串 s 和 t，它们只包含小写字母。
  *               字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
  *               请找出在 t 中被添加的字母。
  * @author: sunhaiting
  * @create: 2020-01-29 21:08
  **/
object ThreeHundredAndNineFindTheDifference {
  def main(args: Array[String]): Unit = {
    val s = "abcd"
    val t = "abcde"
    val c = findTheDifference3(s, t)
    println(c)

  }

  /**
    * 输入：
    * s = "abcd"
    * t = "abcde"
    *
    * 输出：
    * e
    *
    * 数组方法
    *
    * @param s
    * @param t
    * @return
    */
  def findTheDifference1(s: String, t: String): Char = {
    var result: Char = '_'
    val arr = new Array[Int](26)
    for (i <- 0 until s.length) {
      arr(s.charAt(i) - 'a') = arr(s.charAt(i) - 'a') + 1
    }

    for (i <- 0 until t.length; if (result == '_')) {
      if (arr(t.charAt(i) - 'a') == 0) {
        result = t.charAt(i)
      } else {
        arr(t.charAt(i) - 'a') = arr(t.charAt(i) - 'a') - 1
      }
    }
    result
  }

  /**
    * hashMap方法
    *
    * @param s
    * @param t
    * @return
    */
  def findTheDifference2(s: String, t: String): Char = {

    var result = '_'
    val map = new util.HashMap[Char, Int]()
    for (i <- 0 until s.length) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1)
    }

    for (i <- 0 until t.length; if (result == '_')) {
      if (map.getOrDefault(t.charAt(i), 0) == 0) {
        result = t.charAt(i)
      } else {
        map.put(t.charAt(i), map.get(t.charAt(i)) - 1)
      }
    }
    result
  }

  /**
    * 位运算（异或运算）
    * 相同为0，不同为1
    *
    * @param s
    * @param t
    * @return
    */
  def findTheDifference3(s: String, t: String): Char = {

    var result: Char =0
    for (i <- 0 until s.length) {
      val char: Char = s.charAt(i)
      result = (result ^ char).toChar
    }

    for (i <- 0 until t.length) {
      val char: Char = t.charAt(i)
      result = (result ^ char).toChar
    }

    result
  }
}
