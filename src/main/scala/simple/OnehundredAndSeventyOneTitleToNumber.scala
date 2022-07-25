package simple

/**
  *
  * @description: 171.给定一个Excel表格中的列名称，返回其相应的列序号。
  * @author: sunhaiting
  * @create: 2019-11-22 15:01
  **/
object OnehundredAndSeventyOneTitleToNumber {
  def main(args: Array[String]): Unit = {
    val result = titleToNumber("AZ")
    println(result)
  }

  /**
    * A -> 1
    * B -> 2
    * C -> 3
    * ...
    * Z -> 26
    * AA -> 27
    * AB -> 28
    *
    * @param s
    * @return
    */
  def titleToNumber(s: String): Int = {
    var number = 0

    for (i <- 0 until s.length) {
      val c = s.charAt(i)
      number = (c - 'A' + 1) + 26 * number
    }
    number
  }
}
