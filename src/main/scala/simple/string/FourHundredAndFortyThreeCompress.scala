package simple.string

/**
  *
  * @description: 443. 压缩字符串
  *               给定一组字符，使用原地算法将其压缩。
  *               压缩后的长度必须始终小于或等于原数组长度。
  *               数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
  *               在完成原地修改输入数组后，返回数组的新长度。
  * @author: sunhaiting
  * @create: 2020-02-20 21:36
  **/
object FourHundredAndFortyThreeCompress {
  def main(args: Array[String]): Unit = {
    val s = Array('a', 'a', 'b', 'b', 'c', 'c', 'c')
    val i = compress(s)
    println(i)

  }

  /**
    * 输入：
    * ["a","a","b","b","c","c","c"]
    * 输出：
    * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
    *
    * @param chars
    * @return
    */
  def compress(chars: Array[Char]): Int = {
    var left = 0
    var size = 0

    for (right <- 0 to chars.length) {
      if (right == chars.length || chars(left) != chars(right)) {
        chars(size) = chars(left)
        size = size + 1
        if (right - left > 1) {
          //循环遍历的原因是可能right-left>10，这样数组中要存多个值
          val s = ((right - left) + "").toCharArray
          for (c <- s) {
            chars(size) = c
            size = size + 1
          }
        }
        left = right
      }
    }
    size
  }
}
