package secondary.num


/**
  *
  * @description: 12. 整数转罗马数字
  * @author: sunhaiting
  * @create: 2020-03-07 23:48
  **/
object TwelveIntToRoman {
  def main(args: Array[String]): Unit = {

    val str = intToRoman(50000)
    println(str)
  }

  /**
    * 贪心算法
    *
    * @param num
    * @return
    */
  def intToRoman(num: Int): String = {

    val romanArr = Array("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val arab = Array(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val ans = new StringBuilder()
    var num1 = num
    var index = 0
    while (num1 > 0) {
      var count = num1 / arab(index)
      while (count > 0) {
        ans.append(romanArr(index))
        count = count - 1
      }
      num1 = num1 % arab(index)
      index = index + 1
    }

    //    while (index < 13) {
    //      while (num1 >= arab(index)) {
    //        ans.append(romanArr(index))
    //        num1 = num1 - arab(index)
    //      }
    //      index = index + 1
    //    }

    ans.toString()

  }

  /**
    * 暴力算法
    * @param num
    * @return
    */
  def intToRoman2(num: Int): String = {


    //    val t = Array.ofDim[String](4, 10)(
    //      ("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"),
    //      ("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"),
    //      ("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"),
    //      ("", "M", "MM", "MMM")
    //    )


    val Q = Array("", "M", "MM", "MMM")
    val B = Array("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val S = Array("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val G = Array("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

    val s = new StringBuilder()
    val s1: String = Q(math.floor(num / 1000).toInt)
    s.append(s1)
    val s2: String = B(math.floor((num % 1000) / 100).toInt)
    s.append(s2)
    val s3: String = S(math.floor((num % 100) / 10).toInt)
    s.append(s3)
    s.append(G(num % 10))

    s.toString()
  }

}
