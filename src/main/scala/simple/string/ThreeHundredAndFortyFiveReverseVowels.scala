package simple.string

import java.util

/**
  *
  * @description: 345. 反转字符串中的元音字母
  * @author: sunhaiting
  * @create: 2020-01-16 14:27
  **/
object ThreeHundredAndFortyFiveReverseVowels {
  def main(args: Array[String]): Unit = {
    val s = "leetcode"
    println(s.toBuffer)
    val str = reverseVowels(s)
    println(str)
  }

  /**
    * 双指针法
    *
    * @param s
    * @return
    */
  def reverseVowels(s: String): String = {
    val list = new util.ArrayList[Char]()
    list.add('A')
    list.add('a')
    list.add('E')
    list.add('e')
    list.add('I')
    list.add('i')
    list.add('O')
    list.add('o')
    list.add('U')
    list.add('u')
    val array = s.toCharArray
    var left = 0
    var right = array.length - 1
    while (left <= right) {
      if (!list.contains(array(left))) {
        left = left + 1
      }
      if (!list.contains(array(right))) {
        right = right - 1
      }
      if (list.contains(array(left)) && list.contains(array(right))) {
        val temp = array(left)
        array(left) = array(right)
        array(right) = temp
        left = left + 1
        right = right - 1
      }
    }
    array.toBuffer.toString()
  }
}
