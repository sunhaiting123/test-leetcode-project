package simple.binary

/**
  *
  * @description: 191. 位1的个数
  *               编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
  * @author: sunhaiting
  * @create: 2019-11-26 11:10
  **/
object OnehundredAndNinetyOneHammingWeight {
  def main(args: Array[String]): Unit = {
    val i = hammingWeight(11)
    println(i)
  }

  /**
    * 示例 1：
    *
    * 输入：00000000000000000000000000001011
    * 输出：3
    * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
    *
    * @param n
    * @return
    */
  def hammingWeight(n: Int): Int = {
    var count = 0
    for (i <- 0 until 32) {
      val tmp = n >> i
      val s = tmp & 1
      if (s == 1) {
        count = count + 1
      }
    }
    count
  }

  /**
    * 我们只需要将该数字与其减一之后的值进行与运算，然后再次循环，直到为0，其循环的次数就是该数字中1的个数。
    * 原理就是n&n-1一定可以消去该数字最后一位的1,，大家可以这样理解，
    * 不管对于n中最后一个一的位置如何比如为....1000...（N个）假设1的后面有N个0，
    * 对于该数字减一而言就变成了....01111....(N个)后面的0全部就因为借位变成了1，
    * 此时将两个数字相与就会把最后一个1之后（包括1）全部变成了0.同理如此循环一定能将所有的1全部变成0，
    * 这样循环的次数就变成了消去1的次数，也就是1的个数。此题面试常考（tx考过），大家可以记一记。
    *
    * @param n
    * @return
    */
  def hammingWeight2(n: Int): Int = {
    var count = 0
    var n1 = n
    while (n1 != 0) {
      n1 = n1 & (n1 - 1)
      count = count + 1
    }
    count
  }


}
