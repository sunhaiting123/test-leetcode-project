package simple.treeNode

import java.util

import common.TreeNodeScala

/**
  *
  * @description: 112. 路径总和
  *               给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
  * @author: sunhaiting
  * @create: 2020-01-01 18:37
  **/
object OnehundredAndTwelveHasPathSum {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    val treeNode4 = new TreeNodeScala(4)
    val treeNode5 = new TreeNodeScala(5)
    val treeNode6 = new TreeNodeScala(6)
    val treeNode7 = new TreeNodeScala(7)
    treeNode1.right = treeNode2
    treeNode1.left = treeNode3
    treeNode3.left = treeNode4
    treeNode3.right = treeNode5
    treeNode5.left = treeNode6
    treeNode5.right = treeNode7

    val bool = hasPathSum2(treeNode1, 15)
    println(bool)
  }

  /**
    * 递归
    *
    * @param root
    * @param sum
    * @return
    */
  def hasPathSum(root: TreeNodeScala, sum: Int): Boolean = {
    var sum1 = sum
    var flag = true
    if (root == null) {
      flag = false
    }
    sum1 = sum1 - root.value
    if (root.left == null && root.right == null) {
      flag = (sum1 == 0)
    } else {
      flag = (hasPathSum(root.left, sum1) || hasPathSum(root.right, sum1))
    }
    flag
  }

  /**
    * 迭代
    *
    * @param root
    * @param sum
    * @return
    */
  def hasPathSum2(root: TreeNodeScala, sum: Int): Boolean = {
    var result = false
    var flag = true
    if (root == null) {
      result = false
      flag = false
    }
    if (flag) {
      val stack: util.Stack[(TreeNodeScala, Int)] = new util.Stack[(TreeNodeScala, Int)]()
      stack.add((root, sum - root.value))
      while (!stack.empty()) {
        val tuple = stack.pop()
        val key = tuple._1
        val value = tuple._2
        if (key.left == null && key.right == null && value == 0) {
          result = true
        } else {
          if (key.left != null) {
            stack.add((key.left, value - key.left.value))
          }
          if (key.right != null) {
            stack.add((key.right, value - key.right.value))
          }
        }
      }
    }
    result
  }

}
