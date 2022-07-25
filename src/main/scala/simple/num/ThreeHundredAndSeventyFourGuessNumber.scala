package simple.num

/**
  *
  * @description: 374. 猜数字大小
  *               我们正在玩一个猜数字游戏。 游戏规则如下：
  *               我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
  *               每次你猜错了，我会告诉你这个数字是大了还是小了。
  *               你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
  *
  *               -1 : 我的数字比较小
  *               1 : 我的数字比较大
  *               0 : 恭喜！你猜对了！
  * @author: sunhaiting
  * @create: 2020-01-19 17:00
  **/
object ThreeHundredAndSeventyFourGuessNumber {


  def main(args: Array[String]): Unit = {
    val i = guessNumber(10)
    println(i)
  }

  /**
    * 二分法
    *
    * @param n
    * @return
    */
  def guessNumber(n: Int): Int = {
    var flag = true
    var result = -1
    var left = 1
    var right = n
    while (left <= right && flag) {
      val mid = left + (right - left) / 2
      val i = guess(mid)
      if (i == 0) {
        result = mid
        flag = false
      } else if (i == -1) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    result
  }

  val NUM = 6
  def guess(num: Int): Int = {
    if (num == NUM) {
      0
    } else if (num < NUM) {
      -1
    } else {
      1
    }
  }
}
