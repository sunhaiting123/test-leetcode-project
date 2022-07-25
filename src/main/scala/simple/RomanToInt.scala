package simple

/**
  *
  * @description: 罗马数字转整数
  *               罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
  *               字符          数值
  *               I             1
  *               V             5
  *               X             10
  *               L             50
  *               C             100
  *               D             500
  *               M             1000
  * @author: sunhaiting
  * @create: 2019-11-07 14:27
  **/
object RomanToInt {
  def main(args: Array[String]): Unit = {
    val str = "MCMXCIV"
    val result = romanToInt(str)
    println(result)
  }

  /**
    *
    * @param s
    * @return
    */
  def romanToInt(s: String): Int = {
    var result = 0
    val map: Map[String, Int] = Map("I" -> 1, "V" -> 5, "X" -> 10, "L" -> 50, "C" -> 100,
      "D" -> 500, "M" -> 1000, "IV" -> 4, "IX" -> 9, "XL" -> 40, "XC" -> 90, "CD" -> 400, "CM" -> 900)
    var i = 0
    while (i < s.length) {
      if (i + 1 < s.length && map.contains(s.substring(i, i + 2))) {
        val d = map.getOrElse(s.substring(i, i + 2), 0)
        result = result + d
        i = i + 2
      } else {
        result = result + map.getOrElse(s.substring(i,i+1), 0)
        i = i + 1
      }
    }
    result
  }

}
