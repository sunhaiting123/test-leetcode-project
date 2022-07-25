package simple.num

/**
  *
  * @description: 405. 数字转换为十六进制数
  *               给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
  * @author: sunhaiting
  * @create: 2020-02-17 15:54
  **/
object FourHundredAndFiveToHex {
  def main(args: Array[String]): Unit = {

    val str = toHex(26)
    println(str)
  }

  /**
    * 与运算+位运算
    *
    * 要将一个十进制数转换为十六进制数，不管其是正数还是负数，都只需要将其二进制表示每四位分成一个单元，
    * 将其取出后计算这四位二进制数代表的十进制数，与0~f之间的数字做一个映射即可。
    * 要把每四位取出也很简单，与0xf进行AND运算即可。
    *
    *
    * 以0x开头的数表示十六进制数
    *
    * 由于int类型一共有32位，每四位移动一次，最多8次
    * @param num
    * @return
    */
  def toHex(num: Int): String = {
    var res = ""
    var num1 = num
    if (num1 == 0) {
      "0"
    } else {
      val HexString = "0123456789abcdef"

      while (num1 != 0 && res.length < 8) {
        val e: Int = num1 & 15
        res = HexString.charAt(e) + res
        num1 = num1 >> 4
      }
      res
    }
  }
}
