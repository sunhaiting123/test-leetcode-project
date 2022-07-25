package simple

/**
  *
  * @description: 70：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
  *               每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
  * @author: sunhaiting
  * @create: 2019-11-12 16:14
  **/
object SeventyClimbStairs {
  def main(args: Array[String]): Unit = {
    val i = climbStairs(5)
    println(i)
  }

  /**
    * 菲波那切数列
    * 输入： 3
    * 输出： 3
    * 解释： 有三种方法可以爬到楼顶。
    * 1.  1 阶 + 1 阶 + 1 阶
    * 2.  1 阶 + 2 阶
    * 3.  2 阶 + 1 阶
    *
    * @param n
    * @return
    */
  def climbStairs(n: Int): Int = {
    var first = 1
    var second = 2
    if (n == 1) {
      second = 1
    }
    if (n == 2) {
      second = 2
    }
    if (n >= 3) {
      for (i <- 3 to n) {
        val three = first + second
        first = second
        second = three
      }
    }
    second
  }
}
