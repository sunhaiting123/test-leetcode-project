package simple.treeNode

import java.util

import common.TreeNodeScala

/**
  *
  * @description: 404. 左叶子之和
  * @author: sunhaiting
  * @create: 2020-02-13 11:39
  **/
object FourHundredAndFourSumOfLeftLeaves {
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

    val i = sumOfLeftLeaves2(treeNode1)
    println(i)
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def sumOfLeftLeaves(root: TreeNodeScala): Int = {
    if (root == null) {
      0
    } else {
      var sum = 0
      val stack = new util.LinkedList[(TreeNodeScala, Boolean)]()
      stack.push((root, false))
      while (!stack.isEmpty) {
        val tuple = stack.poll()
        val node = tuple._1
        val flag = tuple._2
        if (flag && node.left == null && node.right == null) {
          sum = sum + node.value
        }
        if (node.left != null) {
          stack.add((node.left, true))
        }
        if (node.right != null) {
          stack.add((node.right, false))
        }
      }
      sum
    }
  }

  /**
    * 递归
    *
    * @param root
    * @return
    */
  def sumOfLeftLeaves2(root: TreeNodeScala): Int = {
    if (root == null) {
      0
    } else {
      var sum = 0
      if (isLeftLeave(root.left)) {
        sum = sum + root.left.value
      } else {
        sum = sum + sumOfLeftLeaves2(root.left)
      }
      sum = sum + sumOfLeftLeaves2(root.right)
      sum
    }

  }

  /**
    * 判断是否是叶子节点
    * @param treeNode
    * @return
    */
  def isLeftLeave(treeNode: TreeNodeScala): Boolean = {
    treeNode != null && (treeNode.left == null && treeNode.right == null);
  }


}
