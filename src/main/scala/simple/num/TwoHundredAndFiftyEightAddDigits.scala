package simple.num

/**
  *
  * @description: 258.给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
  * @author: sunhaiting
  * @create: 2020-01-13 14:10
  **/
object TwoHundredAndFiftyEightAddDigits {
  def main(args: Array[String]): Unit = {
    val i = addDigits(38)
    println(i)

  }

  /**
    * 2位数
    * num = a * 10 + b
    * num1 = a + b
    * num - num1 = 9 * a;
    * 缩小了a 个9
    * 3位数
    * num = a * 100 + b * 10 + c
    * num1 = a + b + c
    * num - num1 = 99 * a + 9 * b
    * 缩小了(11 * a + b) * 9
    * 开始到结果相差9的倍数
    *
    * 输入: 38
    * 输出: 2
    * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
    *
    * @param num
    * @return
    */
  def addDigits(num: Int): Int = {
    if(num%9==0){
      9
    }else{
      num%9
    }
  }
}
