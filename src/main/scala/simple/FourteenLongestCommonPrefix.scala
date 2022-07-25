package simple

/**
  *
  * @description: 14.编写一个函数来查找字符串数组中的最长公共前缀
  * @author: sunhaiting
  * @create: 2019-11-07 15:00
  **/
object FourteenLongestCommonPrefix {
  def main(args: Array[String]): Unit = {
    val arr = Array("flower", "flow", "flight")
    val result = longestCommonPrefix(arr)
    println(result)
  }

  /**
    * 输入: ["flower","flow","flight"]
    * 输出: "fl"
    *
    * 输入: ["dog","racecar","car"]
    * 输出: ""
    * 解释: 输入不存在公共前缀。
    *
    * @param s
    * @return
    */
  def longestCommonPrefix(s: Array[String]): String = {
    var prefix = s(0)
    if (s.length == 0) {
      prefix = ""
    }
    for (i <- 1 until s.length) {
      //查找prefix在s(i)中一次出现的索引
      while (s(i).indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length - 1)
        if (prefix.isEmpty) {
          prefix = ""
        }
      }
    }
    prefix
  }

  /**
    * 想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行 S​次比较。
    * 优化这类情况的一种方法就是水平扫描。我们从前往后枚举字符串的每一列，
    * 先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
    *
    * @param strs
    * @return
    */
  def longestCommonPrefix2(strs: Array[String]): String = {
    var prefix = strs(0)
    if (strs == null || strs.length == 0) {
      prefix = ""
    }
    for (i <- 0 until strs.length) {
      val c = strs(0).charAt(i)
      //查找prefix在s(i)中一次出现的索引
      for (j <- 1 until strs.length) {
        if (i == strs(j).length || strs(j).charAt(i) != c) {
          prefix = strs(0).substring(0, i)
        }
      }
    }
    prefix
  }







}
