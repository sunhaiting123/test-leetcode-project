package simple.treeNode

import java.util

import common.TreeNodeScala

/**
  *
  * @description: 111. 二叉树的最小深度
  *               给定一个二叉树，找出其最小深度。
  *               最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
  *               说明: 叶子节点是指没有子节点的节点。
  * @author: sunhaiting
  * @create: 2020-01-01 18:06
  **/
object OnehundredAndElevenMinDepth {
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
    treeNode3.left=treeNode4
    treeNode3.right=treeNode5
    treeNode5.left = treeNode6
    treeNode5.right = treeNode7
    val i = minDepth2(treeNode1)
    println(i)
  }

  /**
    * 给定二叉树 [3,9,20,null,null,15,7],
    *
    * 3
    * / \
    * 9  20
    * /  \
    * 15   7
    * 返回它的最小深度  2.
    *
    * 递归
    *
    * @param root
    * @return
    */
  def minDepth(root: TreeNodeScala): Int = {
    if (root == null) {
      0
    } else if (root.left == null && root.right == null) {
      1
    } else {
      var min_depth = Int.MaxValue
      if (root.left != null) {
        min_depth = Math.min(min_depth, minDepth(root.left))
      }
      if (root.right != null) {
        min_depth = Math.min(min_depth, minDepth(root.right))
      }
      min_depth + 1
    }
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def minDepth2(root: TreeNodeScala): Int = {
    var flag = true
    val stack: util.Stack[(TreeNodeScala, Int)] = new util.Stack[(TreeNodeScala, Int)]()
    var min_depth = Int.MaxValue
    if (root == null) {
      flag = false
      min_depth = 0
    } else {
      stack.add((root, 1))
    }
    if (flag) {
      while (!stack.empty()) {
        val tuple = stack.pop()
        val root = tuple._1
        val current_depth = tuple._2
        if (root.left == null && root.right == null) {
          min_depth = Math.min(min_depth, current_depth)
        }
        if (root.left != null) {
          stack.add((root.left, current_depth + 1))
        }
        if (root.right != null) {
          stack.add((root.right, current_depth + 1))
        }
      }
    }
    min_depth
  }


}
