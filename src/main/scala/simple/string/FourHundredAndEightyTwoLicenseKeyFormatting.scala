package simple.string

/**
  *
  * @description: 482. 密钥格式化
  *               给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。
  *               N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，
  *               除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。
  *               两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
  *
  *               给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
  * @author: sunhaiting
  * @create: 2020-02-29 15:24
  **/
object FourHundredAndEightyTwoLicenseKeyFormatting {
  def main(args: Array[String]): Unit = {

    val S = "5F3Z-2e-9-w"
    val K = 4
    val str = licenseKeyFormatting(S,K)
    println(str.toBuffer)
  }

  /**
    *
    * @param S
    * @param K
    * @return
    */
  def licenseKeyFormatting(S: String, K: Int): String = {

    val str = new StringBuilder()
    val result = new StringBuilder()

    val strings = S.split("-")

    for (s <- strings) {
      str.append(s.toUpperCase)
    }
    //第一个分组的个数
    val i: Int = str.length % K

    if (i != 0) {
      val headStr = str.substring(0, i)
      result.append(headStr)
    }

    for (j <- i until(str.length, K)) {
      if(result.length>0){
        result.append("-")
      }
      val midStr = str.substring(j, j + K)
      result.append(midStr)
    }
    result.toString()
  }
}
