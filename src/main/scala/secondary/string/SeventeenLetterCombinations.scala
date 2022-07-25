package secondary.string

import scala.collection.mutable.ListBuffer

/**
  *
  * @description: 17. 电话号码的字母组合
  *               给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
  * @author: sunhaiting
  * @create: 2020-03-09 13:53
  **/
object SeventeenLetterCombinations {
  def main(args: Array[String]): Unit = {

    val digits = "23"
    val strings = letterCombinations(digits)
    println(strings.toBuffer)
  }

  /**
    *
    * @param digits
    * @return
    */
  def letterCombinations(digits: String): List[String] = {
    //注意边界条件
    if (digits == null || digits.length() == 0) {
      null
    } else {
      iterStr(digits, "", 0)
      result.toList
    }
  }

  //最终结果
  val result = new ListBuffer[String]()
  //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
  //这里也可以用map，用数组可以更节省点内存
  val letter_map = Array(" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

  /**
    * 递归函数
    *
    * @param str
    * @param letter
    * @param index
    */
  def iterStr(str: String, letter: String, index: Int): Unit = {
    //递归终止条件
    if (index == str.length) {
      result.append(letter)
      return
    }

    val c = str.charAt(index)
    val num: Int = c - '0'
    val map_string = letter_map(num)

    //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
    for (i <- 0 until map_string.length) {
      iterStr(str, letter + map_string(i), index + 1)
    }
  }


}
