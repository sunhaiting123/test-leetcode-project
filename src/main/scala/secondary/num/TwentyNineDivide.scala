package secondary.num

/**
  *
  * @description: 29. 两数相除
  *               给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
  *               返回被除数 dividend 除以除数 divisor 得到的商。
  * @author: sunhaiting
  * @create: 2020-03-11 11:40
  **/
object TwentyNineDivide {
  def main(args: Array[String]): Unit = {

    val i = divide(16,2)
    println(i)
  }

  def divide(dividend: Int, divisor: Int): Int = {
    var negtive = 0
    //判断是否是Int.MinValue
    var flag = 0
    var dividend1 = dividend
    var divisor1 = divisor
    if (dividend1 == Int.MinValue && divisor1 == -1) Int.MaxValue
    if (dividend1 == Int.MinValue && divisor1 == 1) Int.MinValue
    //如果dividend1是最小值，flag=1
    if (dividend1 == -2147483648) {
      dividend1 = 2147483647
      flag = 1
    }
    if (dividend1 < 0) {
      dividend1 = -dividend1
      negtive = -1
    }
    if (divisor1 < 0) {
      divisor1 = -divisor1
      negtive = -1
    }
    //最终结果
    var ret = 0
    //除数的多少倍
    var count = 1
    //当前除数
    var divisorTmp = divisor
    //不能一点点相减，效率太低，考虑倍减：如2147483647/2》》除以2,4,8,16……不能倍增就从2再开始
    while (dividend1 - divisor1 >= 0) {
      ret = ret + count
      dividend1 = dividend1 - divisorTmp

      if (dividend1 > divisorTmp + divisorTmp) {
        //倍数翻倍
        count = count + count
        //除数翻倍
        divisorTmp = divisorTmp + divisorTmp
      } else {
        count = 1
       divisorTmp= divisor1
      }
    }
    //消除被除数+1的影响，如最后剩3/4，就需要把结果+1
    if (flag == 1) {
      val s = if (dividend1 + 1 == divisor1) 1 else 0
      ret = ret + s
    }
    if (negtive == 0) ret else -ret //正负判断
  }
}
