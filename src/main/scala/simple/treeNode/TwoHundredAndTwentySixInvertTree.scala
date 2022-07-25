package simple.treeNode

import java.util

import common.TreeNodeScala

/**
  *
  * @description: 226. 翻转二叉树
  * @author: sunhaiting
  * @create: 2020-01-06 20:31
  **/
object TwoHundredAndTwentySixInvertTree {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    val treeNode4 = new TreeNodeScala(4)
    val treeNode5 = new TreeNodeScala(5)
    val treeNode6 = new TreeNodeScala(6)
    val treeNode7 = new TreeNodeScala(7)
    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode3.left = treeNode6
    treeNode3.right = treeNode7

    val node = invertTree(treeNode1)
    println(node.value,node.left.value,node.right.value,node.left.left.value,node.left.right.value)
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def invertTree(root: TreeNodeScala): TreeNodeScala = {
    val queue = new util.LinkedList[TreeNodeScala]()
    queue.add(root)
    while (!queue.isEmpty) {
      val node = queue.poll()
      val temp = node.left
      node.left = node.right
      node.right = temp
      if (node.left != null) queue.add(node.left)
      if (node.right != null) queue.add(node.right)
    }
    root
  }

  /**
    * 递归
    *
    * @param root
    * @return
    */
  def invertTree2(root: TreeNodeScala): TreeNodeScala = {
    if (root == null) null
    else {
      val left = invertTree2(root.left)
      val right = invertTree2(root.right)
      root.left = right
      root.right = left
      root
    }
  }

}
