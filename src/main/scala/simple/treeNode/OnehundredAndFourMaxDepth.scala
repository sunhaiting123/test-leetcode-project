package simple.treeNode

import java.util

import common.{TreeNode, TreeNodeScala}

/**
  *
  * @description: 104. 二叉树的最大深度
  *               给定一个二叉树，找出其最大深度。
  *               二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
  *               说明: 叶子节点是指没有子节点的节点。
  * @author: sunhaiting
  * @create: 2020-01-01 10:34
  **/
object OnehundredAndFourMaxDepth {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    treeNode1.right = treeNode2
    treeNode1.left = treeNode3
    treeNode2.left=treeNode3


    val i = maxDepth2(treeNode1)
    println(i)
  }

  /**
    * 递归
    *
    * @param root
    * @return
    */
  def maxDepth(root: TreeNodeScala): Int = {
    if (root == null) {
      0
    } else {
      val max_left_depth = maxDepth(root.left)
      val max_right_depth = maxDepth(root.right)
      println("======", Math.max(max_left_depth, max_right_depth) + 1)
      Math.max(max_left_depth, max_right_depth) + 1
    }
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def maxDepth2(root: TreeNodeScala): Int = {
    val stack: util.Stack[(TreeNodeScala, Int)] = new util.Stack[(TreeNodeScala, Int)]()
    if (root != null) {
      stack.add((root, 1))
    }
    var depth = 0
    while (!stack.empty()) {
      val tuple = stack.pop()
      val key = tuple._1
      val value = tuple._2
      if(key!=null){
        depth = Math.max(depth, value)
        stack.add((key.left, depth + 1))
        stack.add((key.right, depth + 1))
      }
    }
    depth
  }
}
