package simple.num

/**
  *
  * @description: 455. 分发饼干
  *               假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
  *               对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
  *               并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
  *               这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
  * @author: sunhaiting
  * @create: 2020-02-28 21:27
  **/
object FourHundredAndFiftyFiveFindContentChildren {
  def main(args: Array[String]): Unit = {
    val g = Array(1, 2, 3, 4, 5)
    val s = Array(1, 2, 3, 4)
    println(findContentChildren(g, s))


  }

  /**
    * 输入: [1,2,3], [1,1]
    * 输出: 1
    * 时间复杂度O(nLog(n))
    *
    * @param g
    * @param s
    * @return
    */
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val gSort = g.sorted
    val sSort = s.sorted
    var i = 0
    var j = 0
    while (i < gSort.length && j < sSort.length) {
      if (sSort(i) >= gSort(i)) {
        j = j + 1
      }
      i = i + 1

    }

    //    for (a <- s) {
    //      if (a >= g(j)) {
    //       j = j+1
    //        if (j >= g.length) {
    //          return j
    //        }
    //      }
    //    }
    j
  }


}
