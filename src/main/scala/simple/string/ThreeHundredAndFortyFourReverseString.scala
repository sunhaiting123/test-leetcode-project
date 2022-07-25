package simple.string

/**
  *
  * @description: 344. 反转字符串
  *               编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
  *               不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
  *               你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
  * @author: sunhaiting
  * @create: 2020-01-16 14:16
  **/
object ThreeHundredAndFortyFourReverseString {

  def main(args: Array[String]): Unit = {
    val s = Array('h', 'e', 'l', 'l', 'o')
    println(s.toBuffer)
    reverseString(s)
    println(s.toBuffer)
  }

  /**
    * 双指针法
    *
    * @param s
    */
  def reverseString(s: Array[Char]): Unit = {
    var left = 0
    var right = s.length - 1
    while (left < right) {
      val temp = s(left)
      s(left) = s(right)
      s(right) = temp
      left = left + 1
      right = right - 1
    }
  }
}
