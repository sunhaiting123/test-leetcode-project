package simple

import java.util

/**
  *
  * @description: 118.给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
  * @author: sunhaiting
  * @create: 2019-11-19 16:26
  **/
object OnehundredAndEighteenGenerate {
  def main(args: Array[String]): Unit = {
    val list = generate(6)
    println(list.toArray().toBuffer)
  }

  /**
    * 输入: 5
    * 输出:
    * [
    * [1],
    * [1,1],
    * [1,2,1],
    * [1,3,3,1],
    * [1,4,6,4,1]
    * ]
    *
    * @param numRows
    * @return
    */
  def generate(numRows: Int): util.ArrayList[util.ArrayList[Int]] = {

    val list = new util.ArrayList[util.ArrayList[Int]]()

    list.add(new util.ArrayList[Int]())
    list.get(0).add(1)

    for (i <- 1 until numRows) {
      val row: util.ArrayList[Int] = new util.ArrayList[Int]()
      val preRow: util.ArrayList[Int] = list.get(i - 1)
      //第一个元素为1
      row.add(1)
      for (j <- 1 until i) {
        row.add(preRow.get(j - 1) + preRow.get(j))
      }
      //最后一个元素为1
      row.add(1)
      list.add(row)
    }
    list
  }
}
