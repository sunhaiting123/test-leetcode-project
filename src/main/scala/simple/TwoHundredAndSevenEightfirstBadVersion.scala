package simple

/**
  *
  * @description: ${description}
  * @author: sunhaiting
  * @create: 2020-01-13 19:29
  **/
object TwoHundredAndSevenEightfirstBadVersion {
  def main(args: Array[String]): Unit = {

  }

  def isBadVersion(mid: Int): Boolean = {
    false
  }

  /**
    *
    * @param i
    * @return
    */
  def firstBadVersion(i: Int): Int = {
    var left = 1
    var right = i
    while (left < right) {
      val mid = left + (right - left) / 2
      if (isBadVersion(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }
}
