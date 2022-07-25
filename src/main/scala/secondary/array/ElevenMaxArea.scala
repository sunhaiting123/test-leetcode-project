package secondary.array

/**
  *
  * @description: 11. 盛最多水的容器
  *               给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
  *               在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
  *               找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
  *               说明：你不能倾斜容器，且 n 的值至少为 2。
  * @author: sunhaiting
  * @create: 2020-03-07 23:18
  **/
object ElevenMaxArea {
  def main(args: Array[String]): Unit = {

    val arr = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val i = maxArea(arr)
    println(i)
  }

  /**
    * 使用双指针法
    * @param height
    * @return
    */
  def maxArea(height: Array[Int]): Int = {
    var i = 0
    var j = height.length - 1

    var area = 0
    while (i < j) {
      if (height(i) < height(j)) {
        area = math.max(area, (j - i) * height(i))
        i = i + 1
      } else {
        area = math.max(area, (j - i) * height(j))
        j = j - 1
      }
    }
    area
  }
}
