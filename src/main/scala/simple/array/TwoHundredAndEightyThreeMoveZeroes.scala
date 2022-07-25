package simple.array

/**
  *
  * @description: 283. 移动零
  *               给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
  * @author: sunhaiting
  * @create: 2020-01-13 19:48
  **/
object TwoHundredAndEightyThreeMoveZeroes {
  def main(args: Array[String]): Unit = {
    val arr = Array(0, 1, 0, 3, 12)
    val arr2 = moveZeroes(arr)
    println(arr2.toBuffer)

  }

  /**
    * 示例:
    *
    * 输入: [0,1,0,3,12]
    * 输出: [1,3,12,0,0]
    * 必须在原数组上操作，不能拷贝额外的数组。
    * 尽量减少操作次数。
    *
    * @param nums
    */
  def moveZeroes(nums: Array[Int]): Array[Int] = {
    var j = 0
    for (i <- 0 until nums.length) {
      if (nums(i) != 0) {
        nums(j) = nums(i)
        j = j + 1
      }
    }
    for (k <- j until nums.length) {
      nums(k) = 0
    }
    nums
  }

}



