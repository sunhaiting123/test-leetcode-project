package secondary.string


/**
  *
  * @description: 8. 字符串转换整数 (atoi)
  * @author: sunhaiting
  * @create: 2020-03-07 22:06
  **/
object EightMyAtoi {
  def main(args: Array[String]): Unit = {

    val str = "a-123a"
    val i = myAtoi(str)
    println(i)
  }

  /**
    * 示例 1:
    *
    * 输入: "42"
    * 输出: 42
    *
    * @param str
    * @return
    */
  def myAtoi(str: String): Int = {
    var result = 0
    if (!str.isEmpty) {
      val array: Array[Char] = str.toCharArray
      val n = str.length
      var sign = 1
      var i = 0
      var ans: Long = 0
      //找到第一个非空字符
      while (i < n && array(i) == ' ') {
        i = i + 1
      }
      //如果第一个非空字符为+，则sign值不变仍为1
      if (i < n && array(i) == '+') {
        i = i + 1
      }
      //如果第一个非空字符为-，则把标记sign赋值为1
      if (i < n && array(i) == '-') {
        i = i + 1
        sign = -1
      }
      //只判断是数字的情况
      var flag = true
      while (i < n && array(i) >= '0' && array(i) <= '9' && flag) {

        if (ans != ans.toInt) {
          if (sign == 1) {
            result = Int.MaxValue
          } else {
            result = Int.MinValue
          }
          flag = false
        }
        ans = ans * 10 + (array(i) - '0')
        i=i+1
      }

      if (ans != ans.toInt) {
        if (sign == 1) result = Int.MaxValue
        else result = Int.MinValue
      } else {
        result = (ans * sign).toInt
      }
    }
    result
  }
}
