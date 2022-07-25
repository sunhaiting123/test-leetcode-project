package simple

/**
  *
  * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
  *               假设我们的环境只能存储得下 32 位的有符号整数，
  *               则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
  * @author: sunhaiting
  * @create: 2019-11-07 10:42
  **/
object ReverseNum {
  def main(args: Array[String]): Unit = {
    val x = 120
    val result = reverseNum(x)
    println(result)
  }

  /**
    * 输入: -123
    * 输出: -321
    *
    *
    * 输入: 120
    * 输出: 21
    * int类型的范围是 -2^31——2^31-1，即-2147483648——2147483647
    * 字符串转换效率低
    *
    * @param x
    * @return
    */
  def reverseNum(x: Int): Int = {

    var result = 0
    try {
      if (x < 0) {
        val x1 = -x
        val reverse: String = x1.toString.reverse
        if (reverse.charAt(0) == 0) {
          result = -reverse.substring(1, reverse.length - 1).toInt
        } else {
          result = -reverse.toInt
        }
      } else {
        val reverse: String = x.toString.reverse
        if (reverse.charAt(0) == 0) {
          result = reverse.substring(1, reverse.length - 1).toInt
        } else {
          result = reverse.toInt
        }
      }
    } catch {
      case e: Exception => println("溢出")
    }
    result
  }

  /**
    * 溢出前进行检查(int类型数字有范围限制，反转过后可能会溢出int的范围)
    * （-2147483648——2147483647）
    *
    * @param x
    * @return
    */
  def reverseNum2(x: Int): Int = {
    var x1 = x
    var rev = 0
    while (x1 != 0) {
      val pop = x1 % 10
      x1 = x1 / 10
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
        rev = 0
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
        rev = 0
      }
      else {
        rev = rev * 10 + pop
      }
    }
    rev
  }

}
