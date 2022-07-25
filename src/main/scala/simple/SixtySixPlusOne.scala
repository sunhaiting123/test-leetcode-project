package simple

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @description: 66:给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
  *               最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
  *               你可以假设除了整数 0 之外，这个整数不会以零开头。
  * @author: sunhaiting
  * @create: 2019-11-11 17:11
  **/
object SixtySixPlusOne {
  def main(args: Array[String]): Unit = {

    val arr2 = Array(9, 9, 9, 9)
    println(plusOne(arr2).toBuffer)

  }

  /**
    *
    * 输入: [4,3,2,1]
    * 输出: [4,3,2,2]
    * 解释: 输入数组表示数字 4321。
    *
    * @param digits
    * @return
    */
  def plusOne(digits: Array[Int]): Array[Int] = {
    var digit = digits
    val len = digit.length
    var i = len - 1
    digit(i) += 1
    if (digit(i) > 9) {
      while (i > 0 && digit(i) > 9) {
        digit(i) = 0
        i = i - 1
        digit(i) += 1
      }
      if (i == 0 && digit(i) > 9) {
        digit = new Array[Int](len + 1)
        digit(0) = 1
      }
    }
    digit
  }


}
