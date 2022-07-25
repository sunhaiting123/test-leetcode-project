package simple.num

/**
  *
  * @description: 231.给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
  * @author: sunhaiting
  * @create: 2019-11-27 17:48
  **/
object TwohundredAndTirtyOneIsPowerOfTwo {
  def main(args: Array[String]): Unit = {
    val bool = isPowerOfTwo(1024)
    println(bool)
  }

  /**
    * 输入: 16
    * 输出: true
    * 解释: 2^4 = 16
    *
    * 若 n = 2^x 且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件：
    *
    * 恒有 n & (n - 1) == 0，这是因为：
    * n 二进制最高位为 1，其余所有位为 000；
    * n−1二进制最高位为 000，其余所有位为 111；
    * 一定满足 n > 0。
    *
    * @param n
    * @return
    */
  def isPowerOfTwo(n: Int): Boolean = {
    //n和n-1的位运算
    val s = n & (n - 1)

    n > 0 && (s == 0)


  }
}
