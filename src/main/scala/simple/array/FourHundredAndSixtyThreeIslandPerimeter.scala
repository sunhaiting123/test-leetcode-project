package simple.array

/**
  *
  * @description: 463. 岛屿的周长
  *               给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
  *
  *               网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
  *               但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
  *
  *               岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
  *               网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
  *
  * @author: sunhaiting
  * @create: 2020-02-28 23:19
  **/
object FourHundredAndSixtyThreeIslandPerimeter {
  def main(args: Array[String]): Unit = {

    val arr = Array(Array(0,1,0,0),Array(1,1,1,0),Array(0,1,0,0),Array(1,1,0,0),Array(1,0,0,0))
    val i = islandPerimeter(arr)
    println(i)
  }

  /**
    *
    * @param grid
    * @return
    */
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var count = 0

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {

        if (grid(i)(j) == 1) {
          //上
          if (i == 0 || (i > 0 && grid(i - 1)(j) == 0)) {
            count = count + 1
          }
          //下
          if (i+1 == grid.length || (i+1<grid.length &&grid(i + 1)(j) == 0)) {
            count = count + 1
          }
          //左
          if (j == 0 || (j > 0 && grid(i)(j - 1) == 0)) {
            count = count + 1
          }
          //右
          if (j+1 == grid(i).length || (j+1<grid(i).length && grid(i)(j + 1) == 0)) {
            count = count + 1
          }
        }
      }
    }
    count
  }

}
