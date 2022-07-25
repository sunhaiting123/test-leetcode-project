package secondary.array

/**
  *
  * @description: 81. 搜索旋转排序数组 II
  *               假设按照升序排序的数组在预先未知的某个点上进行了旋转。
  *               ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
  *               编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
  * @author: sunhaiting
  * @create: 2020-03-11 23:26
  **/
object EightyOneSearch {
  def main(args: Array[String]): Unit = {

    val nums = Array(5, 6, 7, 8, 1, 2, 3, 4)
    val bool = search(nums, 8)
    println(bool)
  }

  /**
    * 输入: nums = [2,5,6,0,0,1,2], target = 0
    * 输出: true
    *
    * @param nums
    * @param target
    * @return
    */
  def search(nums: Array[Int], target: Int): Boolean = {


    var result = false
    if (nums != null && nums.length != 0) {
      var left = 0
      var right = nums.length - 1
      while (left <= right) {
        var flag = true
        val mid = left + (right - left) / 2
        if (nums(mid) == target) {
          result = true
        }
        //10111 和 11101 这种分不清前后哪个有序，所以去掉重复项
        if (nums(left) == nums(mid)) {
          left = left + 1
          flag = false
        }
        //当nums(left) != nums(mid)时，可以区分前后哪部分有序
        if (flag) {
          if (nums(left) < nums(mid)) {
            if (target >= nums(left) && target < nums(mid)) {
              right = mid - 1
            } else {
              left = mid + 1
            }
          } else {
            if (target > nums(mid) && target <= nums(right)) {
              left = mid + 1
            } else {
              right = mid - 1
            }

          }
        }
      }
    }
    result
  }
}
