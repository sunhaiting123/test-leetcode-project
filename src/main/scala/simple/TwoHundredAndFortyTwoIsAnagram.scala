package simple


/**
  *
  * @description:242. 有效的字母异位词
  * @author: sunhaiting
  * @create: 2020-01-09 10:15
  **/
object TwoHundredAndFortyTwoIsAnagram {
  def main(args: Array[String]): Unit = {
    val s = "anagram"
    val t = "nagaram"
    val bool = isAnagram(s, t)
    println(bool)
  }

  /**
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    * 示例 1:
    * 输入: s = "anagram", t = "nagaram"
    * 输出: true
    *
    * @param s
    * @param t
    * @return
    */
  def isAnagram(s: String, t: String): Boolean = {
    var flag = true
    if (s.length != t.length) {
      flag = false
    } else {
      val arrs: Array[Int] = new Array[Int](26)
      for (i <- 0 until s.length) {
        arrs(s.charAt(i) - 'a') = arrs(s.charAt(i) - 'a') + 1
        arrs(t.charAt(i) - 'a') = arrs(t.charAt(i) - 'a') - 1
      }
      for (i <- 0 until arrs.length; if flag) {
        val m: Int = arrs(i)
        if (m != 0) {
          flag = false
        }
      }
    }
    flag
  }
}
