package simple


/**
  *
  * @description: 125.给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
  *               说明：本题中，我们将空字符串定义为有效的回文串。
  * @author: sunhaiting
  * @create: 2019-11-20 15:14
  **/
object OnehundredAndTwentyFiveIsPalindrome {
  def main(args: Array[String]): Unit = {

    val s = "A man, a plan, a canal: Panama"
    //    val str = s.replaceAll("[^a-z^A-Z^0-9]", "")
    //    println(str)
    println(s.length)
    val s1 = "race a car"
    val bool = isPalindrome2(s)
    println(bool)

  }

  /**
    * 示例 1:
    *
    * 输入: "A man, a plan, a canal: Panama"
    * 输出: true
    *
    * 示例 2:
    *
    * 输入: "race a car"
    * 输出: false
    *
    * @param s
    * @return
    */
  def isPalindrome(s: String): Boolean = {
    var bool = true
    val str = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase()
    var flag = true
    var i = 0
    while (i < str.length / 2 && flag) {
      if (str.charAt(i) != str.charAt(str.length - 1 - i)) {
        bool = false
        flag = false
      }
      i = i + 1
    }
    bool
  }

  /**
    * 双指针方法
    *
    * @param s
    * @return
    */
  def isPalindrome2(s: String): Boolean = {
    val cArrs: Array[Char] = s.toCharArray
    var i = 0
    var j = cArrs.length - 1
    while (i < j) {
      var temp: Char = ' '
      //判断是否为字符和数字
      val flag1 = (cArrs(i) >= '0' && cArrs(i) <= '9') || (cArrs(i) >= 'a' && cArrs(i) <= 'z') || (cArrs(i) >= 'A' && cArrs(i) <= 'Z')
      val flag2 = (cArrs(j) >= '0' && cArrs(j) <= '9') || (cArrs(j) >= 'a' && cArrs(j) <= 'z') || (cArrs(j) >= 'A' && cArrs(j) <= 'Z')
      if (!flag1 && flag2) j = j + 1
      if (flag1 && !flag2) i = i - 1
      if (flag1 && flag2) {
        temp = cArrs(j)
        cArrs(j) = cArrs(i)
        cArrs(i) = temp
      }
      i = i + 1
      j = j - 1
    }
    s.equalsIgnoreCase(String.valueOf(cArrs))
  }

}
