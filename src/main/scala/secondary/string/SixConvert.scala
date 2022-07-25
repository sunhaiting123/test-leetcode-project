package secondary.string

/**
  *
  * @description: 6. Z 字形变换
  *               将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
  * @author: sunhaiting
  * @create: 2020-03-07 21:29
  **/
object SixConvert {
  def main(args: Array[String]): Unit = {

    val s = "LEETCODEISHIRING"
    //LCIRETOESIIGEDHN
    val str3 = convert(s,3)
    //LDREOEIIECIHNTSG
    val str4 = convert(s,4)
    println(str4)
  }

  /**
    *
    * @param s
    * @param numRows
    * @return
    */
  def convert(s: String, numRows: Int): String = {
    val res = new StringBuilder()
    val cyc = 2 * numRows - 2

    for (i <- 0 until numRows) {
      var j = 0
      while (j + i < s.length) {
        res.append(s.charAt(j + i))
        //在中间行时，每行一个元素
        if (i != 0 && i != numRows - 1 && j + cyc - i < s.length)
          res.append(s.charAt(j + cyc - i))
        j = j + cyc
      }
    }
    res.toString()
  }
}
