package simple.array

/**
  *
  * @description: 26. 删除排序数组中的重复项
  * @author: sunhaiting
  * @create: 2019-11-07 19:43
  **/
object TwentySixRemoveDuplicates {
  def main(args: Array[String]): Unit = {
    val nums = Array[Int](0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val result = removeDuplicates(nums)
    println(nums.toBuffer)
    println(result)
  }

  /**
    * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
    * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
    * 你不需要考虑数组中超出新长度后面的元素。
    *
    * @param nums
    * @return
    */
  def removeDuplicates(nums: Array[Int]): Int = {

    var flag = true
    var result = 0
    if (nums.length == 0) {
      result = 0
      flag = false
    }
    if (flag) {
      var i = 0
      for (j <- 1 until nums.length) {
        if (nums(j) != nums(i)) {
          i = i + 1
          nums(i) = nums(j)
        }
      }
      result = i + 1
    }
    result
  }


}
