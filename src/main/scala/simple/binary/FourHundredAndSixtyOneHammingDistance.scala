package simple.binary

/**
  *
  * @description: 461. 汉明距离
  *               两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
  *               给出两个整数 x 和 y，计算它们之间的汉明距离。
  * @author: sunhaiting
  * @create: 2020-02-28 22:28
  **/
object FourHundredAndSixtyOneHammingDistance {
  def main(args: Array[String]): Unit = {
    val i = hammingDistance(1,4)
    println(i)

  }

  /**
    *两个数做异或运算，再判断1的个数
    * @param x
    * @param y
    * @return
    */
  def hammingDistance(x: Int, y: Int): Int = {
    var count = 0
    var a = x ^ y
    while (a != 0) {
      count = count + 1
      a = a & (a - 1)
    }

    count
  }

  /**
    * 使用内置函数bitCount
    * bitCount：计算一个数二进制形式中1的个数
    * @param x
    * @param y
    * @return
    */
  def hammingDistance2(x: Int, y: Int): Int = {
     Integer.bitCount(x^y)
  }

}
