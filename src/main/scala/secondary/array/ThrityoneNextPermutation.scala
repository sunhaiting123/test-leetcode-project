package secondary.array

/**
  *
  * @description: 31. 下一个排列
  *               实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
  *               如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
  *               必须原地修改，只允许使用额外常数空间。
  * @author: sunhaiting
  * @create: 2020-03-11 21:44
  **/
object ThrityoneNextPermutation {
  def main(args: Array[String]): Unit = {

    val nums = Array(5,1,2,3,4)
    val ints = nextPermutation(nums)
    println(ints.toBuffer)
  }

  /**
    * 1,2,3 → 1,3,2
    * 3,2,1 → 1,2,3
    * 1,1,5 → 1,5,1
    *
    * @param nums
    */
  def nextPermutation(nums: Array[Int]): Array[Int] = {
    var i = nums.length - 2
    while (i >= 0 && nums(i + 1) <= nums(i)) {
      i = i - 1
    }
    //数组是降序排列
    if (i == -1) {
      var a = 0
      var b = nums.length - 1
      while (a < b) {
        //调整为升序排列
        val tmp = nums(a)
        nums(a) = nums(b)
        nums(b) = tmp
        a = a + 1
        b = b - 1
      }
    } else {
      var j = nums.length - 1
      while (j >= 0 && nums(i) > nums(j)) {
        j = j - 1
      }
      //当找到第一个比nums(i)大的值时，交换两个值的位置
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
      //再交换i位置之后的数据，按照从小到大排列
      var k = nums.length - 1
      while (i + 1 < k) {
        val tmp = nums(i + 1)
        nums(i + 1) = nums(k)
        nums(k) = tmp
        i = i + 1
        k = k - 1
      }
    }
    nums
  }
}
