package simple

/**
  *
  * @description: 263:编写一个程序判断给定的数是否为丑数。
  *               丑数就是只包含质因数 2, 3, 5 的正整数。
  * @author: sunhaiting
  * @create: 2020-01-13 15:58
  **/
object TwoHundredAndSixtyThreeIsUgly {
  def main(args: Array[String]): Unit = {

    val bool = isUgly(16)
    println(bool)
  }


  /**
    * 示例 1:
    *
    * 输入: 6
    * 输出: true
    * 解释: 6 = 2 × 3
    *
    * @param num
    * @return
    */
  def isUgly(num: Int): Boolean = {
    var flag = true
    var num1 = num
    if (num1 > 0) {
      while (num1 != 1 && flag ) {
        if (num1 % 2 == 0) num1 = num1 / 2
        else if (num1 % 3 == 0) num1 = num1 / 3
        else if (num1 % 5 == 0) num1 = num1 / 5
        else flag = false
      }
    }
    flag
  }
}
