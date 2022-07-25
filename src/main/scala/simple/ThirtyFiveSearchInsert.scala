package simple

/**
  *
  * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
  *               如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
  * @author: sunhaiting
  * @create: 2019-11-08 15:21
  **/
object ThirtyFiveSearchInsert {
  def main(args: Array[String]): Unit = {

    val arr = Array[Int](1,3,5,6)
    val target =3
    val result =searchInsert(arr,target)
    println(result)
  }

  /**
    * 输入: [1,3,5,6], 5
    * 输出: 2
    *
    * @param nums
    * @param target
    * @return
    */
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length -1
    var flag =true

    val len = nums.length
    if (nums(len - 1) < target || nums(0) >target ) {
      left =len
      flag =false
    }

    while (left < right && flag) {
      val mid = left + (right - left) / 2
      if (target > nums(mid)) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    left
  }
}
