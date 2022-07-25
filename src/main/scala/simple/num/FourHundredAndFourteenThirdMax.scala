package simple.num

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 414. 第三大的数
  *               给定一个非空数组，返回此数组中第三大的数。
  *               如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
  * @author: sunhaiting
  * @create: 2020-02-18 11:10
  **/
object FourHundredAndFourteenThirdMax {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2)
    val i = thirdMax2(arr)
    println(i)


  }

  /**
    * 使用红黑树进行操作
    * 时间复杂度： O(n * log3) == O(n)
    *
    * @param nums
    * @return
    */
  def thirdMax(nums: Array[Int]): Int = {
    val set = new java.util.TreeSet[Int]()
    for (num <- nums) {
      set.add(num)
      if (set.size > 3) {
        set.remove(set.first())
      }
    }
    if (set.size < 3) {
      set.last()
    } else {
      set.first()
    }
  }

  /**
    * 定义三个变量，存放第一、第二、第三大的值
    * 时间复杂度： O(n)
    *
    * @param nums
    * @return
    */
  def thirdMax2(nums: Array[Int]): Int = {
    var result = 0
    var one = nums(0)
    var two = Long.MinValue
    var three = Long.MinValue
    for (i <- 1 until nums.length) {
      val now = nums(i)
      //退出本次循环
      breakable {
        if (now == one || now == two || now == three) {
          println(now, "now ==========")
          break
        }
        if (now > one) {
          three = two
          two = one
          one = now
        } else if (now > two) {
          three = two
          two = now
        } else if (now > three) {
          three = now
        }
        println(now, "********************")
      }
    }
    if (three == Long.MinValue) {
      result = one
    } else {
      result = three.toInt
    }
    result
  }
}
