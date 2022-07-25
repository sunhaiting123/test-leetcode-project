package secondary.list

import scala.collection.mutable.ListBuffer

/**
  *
  * @description: 22. 括号生成
  *               给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
  * @author: sunhaiting
  * @create: 2020-03-10 22:08
  **/
object TwentyTwoGenerateParenthesis {
  def main(args: Array[String]): Unit = {

    val strings = generateParenthesis(2)
    println(strings.toBuffer)
  }

  /**
    * 递归
    *
    * @param n
    * @return
    */
  def generateParenthesis(n: Int): List[String] = {
    val list = new ListBuffer[String]()

    if (n == 0) {
      null
    } else {

      dfs("", n, n, list)
      list.toList
    }
  }


  def dfs(s: String, left: Int, right: Int, list: ListBuffer[String]): Unit = {

    if (left == 0 && right == 0) {
      list.append(s)
    }
    if (left > right) {
      return
    }
    if (left > 0) {
      dfs(s + "(", left - 1, right, list)
    }
    if (right > 0) {
      dfs(s + ")", left, right - 1, list)
    }
  }
}
