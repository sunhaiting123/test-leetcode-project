package simple


/**
  *
  * @description: 202.快乐数
  *               一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
  *               然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
  *               如果可以变为 1，那么这个数就是快乐数。
  * @author: sunhaiting
  * @create: 2019-11-26 15:26
  **/
object TwohundredAndTwoIsHappyNum {
  def main(args: Array[String]): Unit = {
    val bool = isHappy2(19)
    println(bool)
  }

  /**
    * 输入: 19
    * 输出: true
    * 解释:
    * 1^2 + 9^2 = 82
    * 8^2 + 2^2 = 68
    * 6^2 + 8^2 = 100
    * 1^2 + 0^2 + 02 = 1
    *
    * 快慢指针方式
    *
    * @param n
    * @return
    */
  def isHappy(n: Int): Boolean = {
    var slow = n
    var fast = n
    do {
      slow = bitSquareSum(slow)
      fast = bitSquareSum(fast)
      fast = bitSquareSum(fast)
    } while (slow != fast)
    slow == 1
  }

  def bitSquareSum(n: Int): Int = {
    var n1 = n
    var sum = 0
    while (n1 > 0) {
      val bit = n1 % 10
      sum += bit * bit
      n1 = n1 / 10
    }
    sum
  }

  /**
    * hash表方法：
    * 枚举每一个快乐数,若不是快乐数继续算下去，算到有重复的数为止。若重复的数字为1，即是true。否则是false
    *
    * @param n
    * @return
    */
  def isHappy2(n: Int): Boolean = {
    var n1 = n
    var result = true
    var flag =true
    val set = new java.util.HashSet[Int]()
    set.add(n1)
    while (n1 != 1 && flag) {
      n1 = bitSquareSum(n1)
      if (set.contains(n1)) {
        result = false
        flag =false
      }
      else set.add(n1)
    }
    result

  }
}
