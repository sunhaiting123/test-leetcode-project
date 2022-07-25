package secondary.num

/**
  *
  * @description: 50. Pow(x, n)
  *               实现 pow(x, n) ，即计算 x 的 n 次幂函数。
  * @author: sunhaiting
  * @create: 2020-03-15 23:14
  **/
object FiftyMyPow {
  def main(args: Array[String]): Unit = {

    val d = myPow3(2, 3)
    println(d)
  }


  /**
    * 暴力算法
    *
    * @param x
    * @param n
    * @return
    */
  def myPow(x: Double, n: Int): Double = {
    var x1 = x
    var n1 = n
    if (n1 < 0) {
      x1 = 1 / x1
      n1 = -n1
    }
    var result = 1.0
    for (i <- 0 until n1) {
      result = result * x1
    }
    result
  }

  /**
    * 递归n
    * (x^(n/2))^2=x^n  ^
    *
    * @param x
    * @param n
    * @return
    */
  def myPow2(x: Double, n: Int): Double = {

    var x1 = x
    var n1: Long = n
    if (n1 < 0) {
      x1 = 1 / x1
      n1 = -n1
    }
    fastPow(x1, n1)

  }

  def fastPow(x: Double, n: Long): Double = {

    if (n == 0) 1.0
    else {
      val d = fastPow(x, n / 2)
      if (n % 2 == 0) {
        d * d
      } else {
        d * d * x
      }
    }
  }

  /**
    * 迭代
    *
    * @param x
    * @param n
    * @return
    */
  def myPow3(x: Double, n: Int): Double = {

    var x1 = x
    var n1: Long = n
    if (n1 < 0) {
      x1 = 1 / x1
      n1 = -n1
    }
    var result = 1.0
    var current_product = x1
    var i: Long = n1
    while (i > 0) {
      if (i % 2 == 1) {
        result = result * current_product
      }
      current_product = current_product * current_product
      i = i / 2
    }
    result
  }

}
