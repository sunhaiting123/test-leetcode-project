package simple.num

/**
  *
  * @description: 367. 有效的完全平方数
  *               给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
  * @author: sunhaiting
  * @create: 2020-01-18 13:31
  **/
object ThreeHundredAndSixtySevenIsPerfectSquare {
  def main(args: Array[String]): Unit = {

    val num = 256
    val bool = isPerfectSquare2(num)
    println(bool)
  }

  /**
    * 二分法
    *
    * @param num
    * @return
    */
  def isPerfectSquare(num: Int): Boolean = {
    var left = 2
    var right = num / 2
    var flag = false
    while (left <= right && !flag) {
      val x = left + (right - left) / 2
      if (x * x == num) {
        flag = true
      } else if (x * x > num) {
        right = x - 1
      } else {
        left = x + 1
      }
    }
    flag
  }


  /**
    * 牛顿法
    *
    * @param num
    * @return
    */
  def isPerfectSquare2(num: Int): Boolean = {
    var a = 0l
    if (num < 2) {
      true
    } else {
      a = num.toLong
      while (a * a > num) {
        a = (a + num / a) / 2
      }
      a * a == num
    }
  }
}
