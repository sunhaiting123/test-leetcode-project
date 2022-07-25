package secondary.matrix

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @description: 54. 螺旋矩阵
  *               给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
  *
  * @author: sunhaiting
  * @create: 2020-03-18 16:57
  **/
object FiftyFoursPiralOrder {
  def main(args: Array[String]): Unit = {
    val arr = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16))
    val ints = spiralOrder(arr)
    println(ints.toBuffer)

  }

  /**
    * 输入:
    * [
    * [ 1, 2, 3 ],
    * [ 4, 5, 6 ],
    * [ 7, 8, 9 ]
    * ]
    * 输出: [1,2,3,6,9,8,7,4,5]
    *
    * @param matrix
    * @return
    */
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {

    val arr = new ArrayBuffer[Int]()
    //行
    val m = matrix.length
    //列
    val n = matrix(0).length
    val count = (math.min(m, n) + 1) / 2
    var i = 0
    while (i < count) {
      for (j <- i until n - i) {
        arr.append(matrix(i)(j))
      }
      for (j <- i + 1 until m - i) {
        arr.append(matrix(j)((n - 1) - i))
      }
      //从右往左，如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即 （m-1-i ）!= i
      for (j <- i until (n - (i + 1)) reverse ;if (m - 1 - i != i)) {
        arr.append(matrix((m - 1) - i)(j))
      }
      //从下往上，如果这一层只有1列，那么第2个循环已经将该列打印了，这里不需要打印，即(n-1-i) != i
      for (j <- i + 1 until (m - (i + 1)) reverse ; if ((n - 1 - i) != i)) {
        arr.append(matrix(j)(i))
      }
      i = i + 1
    }
    arr.toList
  }
}
