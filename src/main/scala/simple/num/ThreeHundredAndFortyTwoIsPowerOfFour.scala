package simple.num

/**
  *
  * @description: 342. 4的幂 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
  * @author: sunhaiting
  * @create: 2020-01-16 13:31
  **/
object ThreeHundredAndFortyTwoIsPowerOfFour {

  def main(args: Array[String]): Unit = {

  }

  /**
    * 循环
    *
    * @param num
    * @return
    */
  def isPowerOfFour(num: Int): Boolean = {

    var num1 = num
    while (num1 % 4 == 0) {
      num1 = num1 / 4
    }
    num1 == 1
  }

  /**
    * 数学计算
    *
    * @param num
    * @return
    */
  def isPowerOfFour2(num: Int): Boolean = {
    //通过对1取余，取出小数部分，看是不是0
    Math.round(Math.log(num) / Math.log(4)) % 1 == 0
  }

  /**
    * 位运算
    * 4的幂转换为二进制，偶数部分为1，奇数部分为0
    * 因此 4 的幂与数字 (101010...10)向与会得到 0。
    *
    * 1010...1010(32位)转换为16进制为aaaaaaaa
    *
    * @param num
    * @return
    */
  def isPowerOfFour3(num: Int): Boolean = {
    (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0)
  }

  /**
    * 位运算+数学运算
    * 首先是2的幂，4的幂是2的偶数幂
    *
    * @param num
    * @return
    */
  def isPowerOfFour4(num: Int): Boolean = {
    (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1)
  }
}
