package simple.array

/**
  *
  * @description: 475. 供暖器
  *               冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
  *               现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
  *               所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
  * @author: sunhaiting
  * @create: 2020-02-29 11:01
  **/
object FourHundredAndSeventyFiveFindRadius {
  def main(args: Array[String]): Unit = {
    val houses = Array(1, 2, 3, 4)
    val heaters = Array(2, 4)
    println(findRadius(houses, heaters))

  }

  /**
    * 先排序，遍历房屋数组，求出每个房屋的最小供暖距离，最后至少保证所有房间都能供暖因此取最大数。
    * 相当于求每个房屋在供暖器数组中的插入位置
    * 1.房屋号小于供暖器最小号，最左边
    * 2.房屋号大于供暖器最大号，最右边
    * 3.房屋号位于数组中间，二分法求出插入位置，再求出左右的最小距离
    *
    * @param houses
    * @param heaters
    * @return
    */
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {

    val houseSorted = houses.sorted
    val heaterSorted = heaters.sorted

    var result = 0
    for (i <- 0 until houseSorted.length) {
      var min = 0
      //房屋在最左边
      if (houseSorted(i) < heaterSorted(0)) {
        min = heaterSorted(0) - houseSorted(i)
        //房屋在最右边
      } else if (houseSorted(i) > heaterSorted(heaterSorted.length - 1)) {
        min = houseSorted(i) - heaterSorted(heaterSorted.length - 1)
        //中间，用二分法查找房屋所在供暖器中的位置
      } else {
        var left = 0
        var right = heaterSorted.length - 1
        while (left < right) {
          val mid = left + (right - left) / 2
          if (houseSorted(i) < heaterSorted(mid)) {
            right = mid
          } else {
            left = mid+1
          }


//          if (houseSorted(i) > heaterSorted(mid)) {
//            left = mid+1
//          } else {
//            right = mid
//          }
        }
        if (houseSorted(i) == heaterSorted(left)) {
          min = 0
        } else {
          min = Math.min(houseSorted(i) - heaterSorted(left - 1), heaterSorted(left) - houseSorted(i))
        }
      }
      result = math.max(result, min)
    }
    result
  }
}
