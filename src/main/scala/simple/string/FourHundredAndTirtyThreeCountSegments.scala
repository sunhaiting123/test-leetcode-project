package simple.string

/**
  *
  * @description: 434. 字符串中的单词数
  *               统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
  * @author: sunhaiting
  * @create: 2020-02-20 17:41
  **/
object FourHundredAndTirtyThreeCountSegments {
  def main(args: Array[String]): Unit = {
    val s = "  Hello, my name is John"
    val i = countSegments(s)
    println(i)
  }

  /**
    * \\s表示   空格,回车,换行等空白符
    * +号表示一个或多个
    *
    * @param s
    * @return
    */
  def countSegments(s: String): Int = {
    val str = s.trim
    if (str.equals("")) {
      0
    } else {
      str.split("\\s+").length
    }
  }
}
