package simple.binary

/**
  *
  * @description: 476. 数字的补数
  *               给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
  * @author: sunhaiting
  * @create: 2020-02-29 12:45
  **/
object FourHundredAndSeventySixFindComplement {
  def main(args: Array[String]): Unit = {
    val i = findComplement(5)
    println(i)
  }

  /**
    * 所只要拿到一个位数和num一样且所有位都为1的数就好了,然后将num和这个数做异或运算
    * 只要找到比num最高1位的位置高一位（左边）就行了，此时该数必然大于num，
    * 如num=5（101）时，这个数为8（1000），将其减1，则得到与num有效二进制位数相同且各位都为1的数。
    *
    * @param num
    * @return
    */
  def findComplement(num: Int): Int = {

    var num1 = 1
    while (num1 <= num) {
      num1 = num1 << 1
    }
    num1 = num1 - 1

    num1 ^ num
  }
}
