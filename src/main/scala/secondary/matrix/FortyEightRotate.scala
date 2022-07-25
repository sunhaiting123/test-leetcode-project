package secondary.matrix

/**
  *
  * @description: 48. 旋转图像
  *               给定一个 n × n 的二维矩阵表示一个图像。
  *               将图像顺时针旋转 90 度。
  * @author: sunhaiting
  * @create: 2020-03-15 19:57
  **/
object FortyEightRotate {
  def main(args: Array[String]): Unit = {

//    val arr = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16))
    val arr = Array(Array(1, 2, 3), Array(4,5,6), Array(7,8,9))

    rotate3(arr)
    println(arr.map(_.toBuffer).toBuffer)
  }

  /**
    * 转置+翻转
    *
    * @param matrix
    */
  def rotate1(matrix: Array[Array[Int]]): Unit = {

    val n = matrix.length
    //矩阵转置
    for (i <- 0 until n) {
      for (j <- i until n) {
        val temp = matrix(j)(i)
        matrix(j)(i) = matrix(i)(j)
        matrix(i)(j) = temp
      }
    }
    //翻转
    for (i <- 0 until n) {
      for (j <- 0 until n / 2) {
        val temp = matrix(i)(j)
        matrix(i)(j) = matrix(i)(n - j - 1)
        matrix(i)(n - j - 1) = temp
      }
    }
  }

  /**
    * 旋转
    *
    * @param matrix
    */
  def rotate2(matrix: Array[Array[Int]]): Unit = {

    val n = matrix.length
    for (i <- 0 until (n / 2 + n % 2)) {
      for (j <- 0 until n / 2) {
        val nums = new Array[Int](4)
        var row = i
        var col = j
        for (i <- 0 until 4) {
          nums(i) = matrix(row)(col)
          val temp = row
          row = col
          col = n - 1 - temp
        }
        for (i <- 0 until 4) {
          matrix(row)(col) = nums((i + 3) % 4)
          val temp = row
          row = col
          col = n - 1 - temp
        }
      }
    }
  }

  /**
    * 单次循环
    *
    * @param matrix
    */
  def rotate3(matrix: Array[Array[Int]]): Unit = {
    val n = matrix.length
    for (i <- 0 until (n + 1) / 2) {
      for (j <- 0 until n / 2) {
        val temp = matrix(n - 1 - j)(i)
        matrix(n - 1 - j)(i) = matrix(n - 1 - i)(n - j - 1)
        matrix(n - 1 - i)(n - j - 1) = matrix(j)(n - 1 - i)
        matrix(j)(n - 1 - i) = matrix(i)(j)
        matrix(i)(j) = temp
      }
    }
  }
}
