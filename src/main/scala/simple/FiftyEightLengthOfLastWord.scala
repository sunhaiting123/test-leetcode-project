package simple

/**
  * @description: 58:给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
  *               如果不存在最后一个单词，请返回 0 。
  *               说明：一个单词是指由字母组成，但不包含任何空格的字符串。
  * @author: sunhaiting
  * @create: 2019-11-11 16:47
  **/
object FiftyEightLengthOfLastWord {
  def main(args: Array[String]): Unit = {
    val s = "Hello    World   "
    val i = lengthOfLastWord(s)
    println(i)
  }

  /**
    *
    * 先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
    * 时间复杂度：O(n)，n为结尾空格和结尾单词总体长度
    *
    * 输入: "Hello World"
    * 输出: 5
    *
    * @param s
    * @return
    */
  def lengthOfLastWord(s: String): Int = {
    var flag = true
    var result = 0
    var end = s.length - 1
    //为了去掉尾部的空格
    while (end >= 0 && s.charAt(end) == ' ') {
      end = end - 1
      if (end < 0) {
        flag = false
      }
    }
    if (flag) {
      var start = end
      while (start >= 0 && s.charAt(start) != ' ') {
        start = start - 1
      }
      result = end - start
    }
    result
  }
}

