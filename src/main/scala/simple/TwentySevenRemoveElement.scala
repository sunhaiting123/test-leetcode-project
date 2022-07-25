package simple

/**
  *
  * @description: 27.给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
  *               不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
  *               元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
  * @author: sunhaiting
  * @create: 2019-11-07 20:20
  **/
object TwentySevenRemoveElement {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 2, 2, 3)
    val variable = 3
    val result = removeElement(nums, variable)

    println(result)
  }

  /**
    * 给定 nums = [3,2,2,3], val = 3,
    *
    * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    *
    * @param nums
    * @param variable
    * @return
    */
  def removeElement(nums: Array[Int], variable: Int): Int = {
    var i = 0
    for (j <- 0 until nums.length) {
      if (nums(j) != variable) {
        nums(i) = nums(j)
        i = i + 1
      }
    }
    i
  }
}
