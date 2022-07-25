package simple.num

/**
  *
  * @description: 69:实现 int sqrt(int x) 函数。
  *               计算并返回 x 的平方根，其中 x 是非负整数。
  *               由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
  * @author: sunhaiting
  * @create: 2019-11-12 15:11
  **/
object SixtyNineMySqrt {
  def main(args: Array[String]): Unit = {
    val i = mySqrt(8)
    val i2 = mySqrt2(8)
    println(i2)
  }

  /**
    * 二分法
    * 时间复杂度：O(log⁡N)，二分法的时间复杂度是对数级别的。
    * 空间复杂度：O(1)，使用了常数个数的辅助空间用于存储和比较。
    *
    * 输入: 8
    * 输出: 2
    * 说明: 8 的平方根是 2.82842...,
    * 由于返回类型是整数，小数部分将被舍去。
    *
    * @param x
    * @return
    */
  def mySqrt(x: Int): Int = {

    var left: Long = 0l
    var right: Long = x / 2 + 1l

    while (left < right) {
      // 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
      val mid: Long = left + (right - left + 1)  / 2
      val square = mid * mid
      if (square > x) {
        right = mid - 1
      } else {
        left = mid
      }
    }
    left.toInt
  }

  /**
    * 牛顿法：
    * 公式：x= (x+tmp_x/x)/2
    *
    * @param x
    * @return
    */
  def mySqrt2(x: Int): Int = {
    var a = 0l
    if (x == 0) {
      a = 0l
    } else {
      a = x.toLong
      while (a * a > x) {
        a = (a + x / a) / 2
      }
    }

    a.toInt
  }

}
