package secondary.num

import scala.collection.mutable

/**
  *
  * @description: 36. 有效的数独
  *               判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
  *               数字 1-9 在每一行只能出现一次。
  *               数字 1-9 在每一列只能出现一次。
  *               数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
  * @author: sunhaiting
  * @create: 2020-03-13 10:36
  **/
object ThirtySixIsValidSudoku {
  def main(args: Array[String]): Unit = {

    val arr: Array[Array[Char]] = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    val bool = isValidSudoku(arr)
    println(bool)
  }

  /**
    *
    * @param board
    * @return
    */
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val row = new Array[mutable.HashMap[Int, Int]](9)
    val col = new Array[mutable.HashMap[Int, Int]](9)
    val box = new Array[mutable.HashMap[Int, Int]](9)
    for(i<-0 until 9){
        row(i)= new mutable.HashMap[Int,Int]()
        col(i)= new mutable.HashMap[Int,Int]()
        box(i)= new mutable.HashMap[Int,Int]()
      }

    var flag = true
    for (i <- 0 until 9; if (flag)) {
      for (j <- 0 until 9; if (flag)) {
        val char = board(i)(j)
        if (char != '.') {
          val num: Int = char-'0'

          val box_index = (i / 3) * 3 + (j / 3)
          row(i).put(num, row(i).getOrElse(num, 0) + 1)
          col(j).put(num, col(j).getOrElse(num, 0) + 1)
          box(box_index).put(num, box(box_index).getOrElse(num, 0) + 1)
          if (row(i).getOrElse(num, 0) > 1 || col(j).getOrElse(num, 0) > 1 || box(box_index).getOrElse(num, 0) > 1) {
            flag = false
          }
        }
      }
    }
    flag
  }
}
