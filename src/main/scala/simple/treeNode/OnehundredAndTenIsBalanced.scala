package simple.treeNode

import common.TreeNodeScala

/**
  *
  * @description: 110. 平衡二叉树
  *               给定一个二叉树，判断它是否是高度平衡的二叉树。
  *               本题中，一棵高度平衡二叉树定义为：
  *               一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
  * @author: sunhaiting
  * @create: 2020-01-01 17:08
  **/
object OnehundredAndTenIsBalanced {
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

    val bool = isBalanced(treeNode1)
    println(bool)
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def isBalanced(root: TreeNodeScala): Boolean = {
    depth(root) != -1

  }


  def depth(root: TreeNodeScala): Int = {
    if (root == null) {
      0
    } else if (depth(root.left) == -1) {
      -1
    } else if (depth(root.right) == -1) {
      -1
    } else {
      if (Math.abs(depth(root.left) - depth(root.right)) < 2) {
        Math.max(depth(root.left), depth(root.right)) + 1
      } else {
        -1
      }
    }
  }
}
