package simple

/**
  *
  * @description: 88:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
  *               初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
  *               你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
  * @author: sunhaiting
  * @create: 2019-11-12 19:36
  **/
object EightyEightMergeArray {
  def main(args: Array[String]): Unit = {

    val a1 = Array(1, 2, 3, 0, 0, 0)
    val a2 = Array(2, 5, 6)
    val ints = merge(a1, 3, a2, a2.length)
    println(ints.toBuffer)
  }

  /** 从前往后构造数组，拿array2中的最前面的元素跟array1中的最前面的元素比较，
    * 找到正确的排序 以后插入，然后把array1后面的元素都向后移一位。
    * 时间复杂度太高。
    *
    * 从后往前写：
    * 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
    *
    * 输入:
    * nums1 = [1,2,3,0,0,0], m = 3
    * nums2 = [2,5,6],       n = 3
    *
    * 输出: [1,2,2,3,5,6]
    *
    * @param nums1
    * @param m
    * @param nums2
    * @param n
    */
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Array[Int] = {

    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1
    while (p1 >= 0 && p2 >= 0) {
      val s1 = nums1(p1)
      val s2 = nums2(p2)

      if (s1 < s2) {
        nums1(p) = s2
        p = p - 1
        p2 = p2 - 1
      } else {
        nums1(p) = s1
        p = p - 1
        p1 = p1 - 1
      }
    }
    nums1

  }
}
