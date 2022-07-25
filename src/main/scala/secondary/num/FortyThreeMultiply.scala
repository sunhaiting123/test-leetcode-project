package secondary.num

import scala.util.control.Breaks.{breakable, break}

/**
  *
  * @description: 43. 字符串相乘
  *               给定两个以字符串形式表示的非负整数 num1 和 num2，
  *               返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
  * @author: sunhaiting
  * @create: 2020-03-14 10:58
  **/
object FortyThreeMultiply {
  def main(args: Array[String]): Unit = {
    val str = multiply2("123", "456")
    println(str)

  }

  /**
    *
    * @param num1
    * @param num2
    * @return
    */
  def multiply(num1: String, num2: String): String = {

    var result = "0"
    if (num1 != "0" && num2 != "0") {
      //
      for (i <- 0 until num2.length reverse) {
        //进位
        var carry = 0
        // 保存 num2 第i位数字与 num1 相乘的结果
        val temp = new StringBuilder()
        //对nums2中的每一位补0
        for (j <- 0 until num2.length - 1 - i) {
          temp.append(0)
        }

        val n2 = num2(i) - '0'

        var k = num1.length - 1
        while (k >= 0 || carry != 0) {
          val n1 = if (k < 0) 0 else num1.charAt(k) - '0'
          val product = (n1 * n2 + carry) % 10
          temp.append(product)
          carry = (n1 * n2 + carry) / 10
          k = k - 1
        }
        //将当前结果与新计算的结果求和作为新的结果
        result = addStrings(result, temp.reverse.toString())
      }
    }
    result
  }


  def addStrings(str1: String, str2: String): String = {

    val builder = new StringBuilder()
    var carry = 0
    var i = str1.length - 1
    var j = str2.length - 1
    while (i >= 0 || j >= 0 || carry != 0) {
      val n1 = if (i < 0) 0 else str1.charAt(i) - '0'
      val n2 = if (j < 0) 0 else str2.charAt(j) - '0'
      val product = (n1 + n2 + carry) % 10
      builder.append(product)
      carry = (n1 + n2 + carry) / 10
      i = i - 1
      j = j - 1
    }
    builder.reverse.toString()

  }

  /**
    * 乘数 num1 位数为 MM，被乘数 num2 位数为 NN， num1 x num2 结果 res 最大总位数为 M+N
    * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，
    * 其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
    *
    * @param num1
    * @param num2
    * @return
    */
  def multiply2(num1: String, num2: String): String = {

    if (num1 == "0" || num2 == "0") {
      "0"
    } else {
      val arr = new Array[Int](num1.length + num2.length)
      for (i <- 0 until num1.length reverse) {
        for (j <- 0 until num2.length reverse) {
          val n1 = num1.charAt(i) - '0'
          val n2 = num2.charAt(j) - '0'
          val sum = n1 * n2 + arr(i + j + 1)
          arr(i + j + 1) = sum % 10
          arr(i + j) = arr(i + j) + sum / 10
        }
      }
      val str = new StringBuilder()
      for (i <- 0 until arr.length) {
        //去掉首位为0的情况
        breakable {
          if (i == 0 && arr(i) == 0) {
            break()
          }
          str.append(arr(i))
        }

      }
      str.toString()
    }
  }
}
