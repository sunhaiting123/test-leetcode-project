package simple

/**
  *
  * @description: 168. Excel表列名称
  * @author: sunhaiting
  * @create: 2019-11-21 15:43
  **/
object OnehundredAndSixtyEightConvertToTitle {
  def main(args: Array[String]): Unit = {
    val str = convertToTitle(28)
    println(str)
  }

  /**
    * 1 -> A
    * 2 -> B
    * 3 -> C
    * ...
    * 26 -> Z
    * 27 -> AA
    * 28 -> AB
    * ...
    * 示例 1:
    *
    * 输入: 1
    * 输出: "A"
    *
    * 示例 2:
    *
    * 输入: 28
    * 输出: "AB"
    *
    * @param n
    * @return
    */
  def convertToTitle(n: Int): String = {
    var n1 =n
    val sb = new StringBuilder()

    while (n1 > 0) {
      var c = n1 % 26
      if (c == 0) {
        c = 26
        n1 = n1 - 1
      }
      sb.insert(0, ('A' + c - 1).toChar)
      println("========="+sb.toString())
      n1 /= 26
    }
    sb.toString()

  }


}
