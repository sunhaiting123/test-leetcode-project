package simple.num

/**
  *
  * @description: 9.判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
  * @author: sunhaiting
  * @create: 2019-11-07 11:28
  **/
object NineIsPalindromeNum {
  def main(args: Array[String]): Unit = {

  }

  /**
    * 按照第二个想法，为了避免数字反转可能导致的溢出问题，
    * 为什么不考虑只反转 int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
    *
    * @param x
    * @return
    */
  def isPalindrome(x: Int): Boolean = {
    var flag = false
    var x1 = x
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if (x1 < 0 || (x1 % 10 == 0 && x1 != 0)) {
      flag = false
    }

    var revertedNumber = 0

    /**
      * 我们将原始数字除以 10，然后给反转后的数字乘上 10，
      * 所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
      */
    while (x1 > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x1 % 10
      x1 = x1 / 10
    }
    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    if (x1 == revertedNumber || x1 == revertedNumber / 10) {
      flag = true
    }
    flag
  }

}
