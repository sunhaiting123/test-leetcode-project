package simple.binary

/**
  *
  * @description: 190. 颠倒二进制位
  * @author: sunhaiting
  * @create: 2019-11-26 11:03
  **/
object OnehundredAndNinetyReverseBits1 {
  def main(args: Array[String]): Unit = {
    val n = 43261596
    val i = reverseBits1(n)
    println(i)
  }

  /**
    * 输入: 00000010100101000001111010011100
    * 输出: 00111001011110000010100101000000
    * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
    * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
    *
    * @param n
    * @return
    */
  def reverseBits1(n: Int): Int = {
    var result = 0
    for (i <- 0 until  32) {
      // 1. 将给定的二进制数,由低到高位逐个取出
      // 1.1 右移 i 位,
      var tmp = n >> i
      // 1.2  取有效位
      tmp = tmp & 1
      // 2. 然后通过位运算将其放置到反转后的位置.
      tmp = tmp << (31 - i)
      // 3. 将上述结果再次通过运算结合到一起
      result = result | tmp
    }
    result
  }
}
