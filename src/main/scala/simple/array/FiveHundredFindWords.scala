package simple.array

import java.util

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 500. 键盘行
  *               给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词.
  * @author: sunhaiting
  * @create: 2020-02-29 22:44
  **/
object FiveHundredFindWords {
  def main(args: Array[String]): Unit = {
    val arr = Array("Hello", "Alaska", "Dad", "Peace")
    val strings = findWords(arr)
    println(strings.toBuffer)
  }

  /**
    *
    * @param words
    * @return
    */
  def findWords(words: Array[String]): Array[String] = {
    val result = mutable.ArrayBuffer[String]()
    if (words == null) {
      null
    } else {
      val lines = Array("qwertyuiop", "asdfghjkl", "zxcvbnm")
      for (word <- words) {
        val bool = judge(word.toLowerCase(), lines)
        if (bool == true) {
          result.append(word)
        }
      }
      result.toArray
    }
  }


  def judge(word: String, lines: Array[String]): Boolean = {
    var flag = true
    var find: String = null
    // 先用word首字符确定属于哪一行
    breakable {
      for (line <- lines) {
        if (line.indexOf(word.charAt(0)) > -1) {
          find = line
          break()
        }
      }
    }
    if (find == null) {
      flag = false
    } else {
      // 判断word字符串所有字符是否都属于同一行
      breakable {
        for (i <- 1 until word.length) {
          if (find.indexOf(word.charAt(i)) < 0) {
            flag = false
            break()
          }
        }
      }
    }
    flag
  }
}
