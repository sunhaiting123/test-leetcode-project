package simple.num

/**
  *
  * @description: 326. 3的幂  给定一个整数，写一个函数来判断它是否是 3 的幂次方。
  * @author: sunhaiting
  * @create: 2020-01-16 12:53
  **/
object ThreeHundredAndTwentySixIsPowerOfThree {
  def main(args: Array[String]): Unit = {

    val s = 18
    val bool = isPowerOfThree(s)
    println(bool)
  }

  /**
    * 循环
    *
    * @param n
    * @return
    */
  def isPowerOfThree(n: Int): Boolean = {
    var n1 = n
    while (n1 % 3 == 0) {
      n1 = n1 / 3
    }
    n == 1
  }

  /**
    * 找到int类型3的倍数最大的值，用这个值对n求余,看余数是否为0
    * 最大值：1162261467
    *
    * @param n
    * @return
    */
  def isPowerOfThree2(n: Int): Boolean = {
    n > 0 && 1162261467 % 3 == 0
  }

  /**
    * 数学计算方式
    *
    * @param n
    * @return
    */
  def isPowerOfThree3(n: Int): Boolean = {
    //通过对1取余，取出小数部分，看是不是0
    Math.round(Math.log(n) / Math.log(3)) % 1 == 0

  }


}
