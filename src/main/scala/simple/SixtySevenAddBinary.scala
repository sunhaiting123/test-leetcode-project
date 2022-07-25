package simple

/**
  *
  * @description: 67:给定两个二进制字符串，返回他们的和（用二进制表示）。
  * @author: sunhaiting
  * @create: 2019-11-11 20:16
  **/
object SixtySevenAddBinary {
  def main(args: Array[String]): Unit = {
    val a = "1010"
    val b = "1011"
    val s: Char = a(1)
    val s2 = a(2)
    //    println(s, s2, s + s2, s + '1')
    //    val s3 = a(1) - '0' + b(1)
    //    a(1) = a(1) - '0' + b(1)
    //    println(s3)


    val str = addBinary(a, b)
    println(str)

  }

  /**
    * 输入: a = "1010", b = "1011"
    * 输出: "10101"
    *
    * 转成数字做容易溢出
    *
    * @param a
    * @param b
    * @return
    */
  def addBinary(a: String, b: String): String = {

    val aLength = a.length
    val bLength = b.length
    val maxLen = Math.max(aLength, bLength)
    // 从个位开始加，个位在字符串的右边
    // 代码访问从左到右，因此先反转一下
    val sbA = new StringBuilder(a).reverse
    val sbB = new StringBuilder(b).reverse

    while (sbA.length < maxLen) {
      sbA.append("0")
    }
    while (sbB.length < maxLen) {
      sbB.append("0")
    }
    val builder = new StringBuilder()
    // 进位，初始时进位为 0
    var carry = 0
    var num1 = 0
    var num2 = 0
    for (i <- 0 until maxLen) {
      // 当前字符的 ASCII 值减去 '0' 的 ASCII 值，相当于将这个字符转换成数值
      num1 = sbA.charAt(i) - '0'
      num2 = sbB.charAt(i) - '0'
      if (carry + num1 + num2 > 1) {
        // 因为是二进制，所以多余 2 的部分要减去
        builder.append(carry + num1 + num2 - 2)
        // 表示要进位
        carry = 1
      } else {
        builder.append(carry + num1 + num2)
        carry = 0
      }
    }
    // 对于最高位还要进位的情况，需要单独判断
    if (carry == 1) {
      builder.append("1")
    }
    // 最后不要忘记再反转一次
    builder.reverse.toString()

  }

  //
  //    StringBuilder res = new StringBuilder();
  //    // 进位，初始时进位为 0
  //    int carry = 0;
  //    // 当前字符的 ASCII 值减去 '0' 的 ASCII 值，相当于将这个字符转换成数值
  //    int num1;
  //    int num2;
  //    for (int i = 0; i < maxLen; i++) {
  //      num1 = sbA.charAt(i) - '0';
  //      num2 = sbB.charAt(i) - '0';
  //      if (carry + num1 + num2 > 1) {
  //        // 因为是二进制，所以多余 2 的部分要减去
  //        res.append(carry + num1 + num2 - 2);
  //        // 表示要进位
  //        carry = 1;
  //      } else {
  //        res.append(carry + num1 + num2);
  //        carry = 0;
  //      }
  //    }
  //    // 对于最高位还要进位的情况，需要单独判断
  //    if (carry == 1) {
  //      res.append("1");
  //    }
  //    // 最后不要忘记再反转一次
  //    return res.reverse().toString();
  //  }

}
