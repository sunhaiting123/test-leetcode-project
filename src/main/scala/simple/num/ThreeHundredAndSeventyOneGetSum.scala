package simple.num

/**
  *
  * @description: 371. 两整数之和
  *               不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
  * @author: sunhaiting
  * @create: 2020-01-18 14:07
  **/
object ThreeHundredAndSeventyOneGetSum {
  def main(args: Array[String]): Unit = {

    val a=6
    val b=2
    val i = getSum(a,b)
    println(i)
  }

  /**
    * 位运算
    *
    * @param a
    * @param b
    * @return
    */
  def getSum(a: Int, b: Int): Int = {
    var a1 = a
    var b1 = b
    while (b1 != 0) {
      val temp  = a1 ^ b1
      b1 = (a1 & b1) << 1
      a1=temp
    }
    a1
  }
}
