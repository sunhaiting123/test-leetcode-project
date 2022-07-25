package simple

import java.util

import scala.util.control.Breaks.{break, breakable}

/**
  *
  * @description: 447. 回旋镖的数量
  *               给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
  *               其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
  *               找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
  * @author: sunhaiting
  * @create: 2020-02-20 22:27
  **/
object FourHundredAndFortySevenNumberOfBoomerangs {
  def main(args: Array[String]): Unit = {

    val a: Array[Array[Int]] = Array(Array(0,0),Array(1,0),Array(2,0),Array(3,0))

    val i = numberOfBoomerangs(a)
    println(i)

  }

  /**
    * 将当前点作为第一个点，计算与非当前点的距离，保存在hashMap中，
    * 若计算距离距离在hashMap中已有值，则表明之前有相同的距离，
    * res，因为可以换位，则乘以2，并更新到当前hash中（可以与当前距离相同的任意一个点交换位置）.
    * 当前点作为第一个点结束之后，清空hashMap，继续以下一个点作为第一个点。
    *
    *
    * @param points
    * @return
    */
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    var result = 0
    val map = new util.HashMap[Double, Int]()
    for (i <- 0 until points.length) {
      map.clear()
      for (j <- 0 until points.length) {
        //如果i==j 跳出本次循环
        breakable {
          if (i == j) {
            break
          }
        }
        val distance: Double = math.pow(points(i)(0) - points(j)(0), 2) + math.pow(points(i)(1) - points(j)(1), 2)
        if (map.containsKey(distance)) {
          result = map.get(distance) * 2
          map.put(distance, map.get(distance) + 1)
        } else {
          map.put(distance, 1)
        }
      }
    }
    result
  }
}
