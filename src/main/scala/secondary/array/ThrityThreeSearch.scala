package secondary.array

/**
  *
  * @description: 33. 搜索旋转排序数组
  *               假设按照升序排序的数组在预先未知的某个点上进行了旋转。
  *               ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
  *               搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
  *               你可以假设数组中不存在重复的元素。
  *               你的算法时间复杂度必须是 O(log n) 级别。
  *
  * @author: sunhaiting
  * @create: 2020-03-11 23:09
  **/
object ThrityThreeSearch {
  def main(args: Array[String]): Unit = {

    val nums = Array(5, 6, 7, 8, 1, 2, 3, 4)
    val i = search(nums, 3)
    println(i)
  }

  /**
    * 输入: nums = [4,5,6,7,0,1,2], target = 0
    * 输出: 4
    *
    * @param nums
    * @param target
    * @return
    */
  def search(nums: Array[Int], target: Int): Int = {
    var result = 0
    if (nums == null || nums.length == 0) {
      result = -1
    } else {
      var left = 0
      var right = nums.length - 1
      while (left <= right) {
       val  mid = left + (right - left) / 2
        if (nums(mid) == target) {
          result = mid
        }
        //前半部分数组有序
        if (nums(left) <= nums(mid)) {

          if (target >= nums(left) && target < nums(mid)) {
            right = mid - 1
          } else {
            left = mid + 1
          }
          //后半部分数组有序
        } else {

          if (target > nums(mid) && target <= nums(right)) {
            left = mid + 1
          } else {
            right = mid - 1
          }
        }
      }
    }
    result
  }
}
