package secondary.array

/**
  *
  * @description: 154. 寻找旋转排序数组中的最小值 II
  *               假设按照升序排序的数组在预先未知的某个点上进行了旋转。
  *               ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
  *               请找出其中最小的元素。
  *               注意数组中可能存在重复的元素。
  * @author: sunhaiting
  * @create: 2020-03-12 00:28
  **/
object OnehundredAndFiftyFourFindMin {
  def main(args: Array[String]): Unit = {
    val nums = Array(5, 6, 7, 8, 1,1,1,1,1, 2,2,2,2, 3, 4,4,4,4)
    val i = findMin(nums)
    println(i)
  }


  def findMin(nums: Array[Int]): Int = {

    var left = 0
    var right = nums.length-1
    while (left<right){
      val mid = left +(right-left)/2
      if(nums(mid)>nums(right)){
        left = mid+1
      }else if(nums(mid)<nums(right)){
        right = mid -1
      }else{
        //去除重复的数据
        right = right -1
      }

    }
    nums(left)
  }
}
