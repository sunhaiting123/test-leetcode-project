package simple.treeNode

import java.util
import java.util.Collections

import common.TreeNodeScala

/**
  *
  * @description: 107. 二叉树的层次遍历
  *               给定一个二叉树，返回其节点值自底向上的层次遍历。
  *               （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
  * @author: sunhaiting
  * @create: 2019-11-14 10:30
  **/
object OnehundredAndSevenLevelOrderBottom {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    val treeNode4 = new TreeNodeScala(4)
    val treeNode5 = new TreeNodeScala(5)
    val treeNode6 = new TreeNodeScala(6)
    val treeNode7 = new TreeNodeScala(7)
    val treeNode8 = new TreeNodeScala(8)
    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode4.left = treeNode7
    treeNode4.right = treeNode8
    treeNode3.right = treeNode6

    //    val ints = preorderTraversal(treeNode1)
    val ints3 = preTraversalRecursive(treeNode1)
    //    println(ints3.toArray.toBuffer)
    val list = levelOrderBottom2(treeNode1)
    println(list.toArray.toBuffer)

  }

  /**
    * 3
    * / \
    * 9  20
    * /  \
    * 15   7
    * 返回值：
    * [
    * [15,7],
    * [9,20],
    * [3]
    * ]
    *
    * 递归
    *
    * @param root
    * @param level
    */
  val levels = new util.ArrayList[util.List[Integer]]()

  //  def levelOrderBottom(root: TreeNode, level: Int): Unit = {
  //
  //    if (levels.size() == level) {
  //      levels.add(new util.ArrayList[Integer]())
  //    }
  //    levels.get(level).add(root.value)
  //
  //    if (root.left != null) {
  //
  //      levelOrderBottom(root.left, level + 1)
  //    }
  //    if (root.right != null) {
  //      levelOrderBottom(root.left, level + 1)
  //    }
  //
  //  }

  /**
    * 迭代的前序遍历
    *
    * @param root
    * @return
    */
  def preorderTraversal(root: TreeNodeScala): util.ArrayList[Int] = {
    val result = new util.ArrayList[Int]()
    //    if (root == null) return result
    val stack = new util.Stack[TreeNodeScala]()
    stack.push(root)
    while (!stack.isEmpty()) {
      val node = stack.pop()
      result.add(node.value)
      if (node.right != null) stack.push(node.right)

      if (node.left != null) stack.push(node.left)
    }
    result
  }

  /**
    * 递归的前序遍历
    *
    * @param root
    */
  def preTraversalRecursive(root: TreeNodeScala): Unit = {

    //    if (root == null) {
    //      return;
    //    }
    // root
    println(root.value + ",")

    // left
    if (root.left != null) {
      preTraversalRecursive(root.left)
    }

    // right
    if (root.right != null) {
      preTraversalRecursive(root.right)
    }
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def levelOrderBottom(root: TreeNodeScala): util.ArrayList[util.ArrayList[Int]] = {
    val result: util.ArrayList[util.ArrayList[Int]] = new util.ArrayList[util.ArrayList[Int]]()
    var flag = true
    if (root == null) {
      flag = false
    }
    if (flag) {
      val list = new util.LinkedList[TreeNodeScala]()
      list.add(root)
      while (!list.isEmpty) {
        val temp = new util.ArrayList[Int]()
        for (i <- 0 until list.size()) {
          val node = list.poll()
          temp.add(node.value)
          if (node.left != null) list.add(node.left)
          if (node.right != null) list.add(node.right)
        }
        println(temp.toArray.toBuffer)
        result.add(temp)
      }
      Collections.reverse(result)
    }
    result
  }

  /**
    * 递归
    *
    * @param root
    * @return
    */
  def levelOrderBottom2(root: TreeNodeScala): util.ArrayList[util.ArrayList[Int]] = {
    val result = new util.ArrayList[util.ArrayList[Int]]()
    helper(root, 0, result)
    Collections.reverse(result)
    result
  }

  def helper(root: TreeNodeScala, depth: Int, result: util.ArrayList[util.ArrayList[Int]]): Unit = {
    var flag = true
    if (root == null) {
      flag = false
    }
    if (flag) {
      if (depth + 1 > result.size()) {
        result.add(new util.ArrayList[Int]())
      }
      result.get(depth).add(root.value)
      if (root.left != null) helper(root.left, depth + 1, result)
      if (root.right != null) helper(root.right, depth + 1, result)
    }
  }

}
