package simple.num

/**
  *
  * @description: 441. 排列硬币
  *                   你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
  *                   给定一个数字 n，找出可形成完整阶梯行的总行数。
  *                   n 是一个非负整数，并且在32位有符号整型的范围内。
  * @author: sunhaiting
  * @create: 2020-02-20 18:34
  **/
object FourHundredAndFortyOneArrangeCoins {
  def main(args: Array[String]): Unit = {

  }

  /**
    * n = 8
    *
    * 硬币可排列成以下几行:
    * ¤
    * ¤ ¤
    * ¤ ¤ ¤
    * ¤ ¤
    * 因为第四行不完整，所以返回3.
    *
    * @param n
    * @return
    */
  def arrangeCoins(n: Int): Int = {
    (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5).toInt
  }
}
