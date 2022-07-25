package simple.array

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 492. 构造矩形
  *               作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
  *               1. 你设计的矩形页面必须等于给定的目标面积。
  *               2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
  *               3. 长度 L 和宽度 W 之间的差距应当尽可能小。
  *               你需要按顺序输出你设计的页面的长度 L 和宽度 W。
  * @author: sunhaiting
  * @create: 2020-02-29 20:40
  **/
object FourHundredAndNinetyTwoConstructRectangle {
  def main(args: Array[String]): Unit = {
    val ints = constructRectangle(5)
    println(ints.toBuffer)

  }

  /**
    * 中心拓展法，先找到平方根再向下拓展。
    * 不要向上拓展，因为 1 到平方根的距离更近。
    *
    * @param area
    * @return
    */
  def constructRectangle(area: Int): Array[Int] = {
    var max = 0
    val s = math.floor(math.sqrt(area)).toInt

    breakable {
      for (i <- s until(0, -1)) {
        if (area % i == 0) {
          max = i
          break()
        }
      }
    }
    Array(area / max, max)
  }
}
