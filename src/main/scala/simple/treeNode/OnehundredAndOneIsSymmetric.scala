package simple.treeNode

import java.util

import common.{TreeNode, TreeNodeScala}

/**
  *
  * @description: 101. 对称二叉树
  *               给定一个二叉树，检查它是否是镜像对称的。
  * @author: sunhaiting
  * @create: 2019-11-13 20:17
  **/
object OnehundredAndOneIsSymmetric {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    treeNode1.right = treeNode2
    treeNode1.left = treeNode2
    treeNode1.right.right = treeNode3
    treeNode1.left.left = treeNode2

    val bool = isSymmetric(treeNode1)
    val bool2 = isSymmetric2(treeNode1)
    println(bool)
    println(bool2)

  }

  /**
    * 递归
    * 二叉树是对称的
    * 1
    * / \
    * 2   2
    * / \ / \
    * 3  4 4  3
    *
    * @param root
    * @return
    */
  def isSymmetric(root: TreeNodeScala): Boolean = {
    isMirror(root, root)

  }

  def isMirror(t1: TreeNodeScala, t2: TreeNodeScala): Boolean = {
    if (t1 == null && t2 == null) true
    else if (t1 == null || t2 == null) false
    else
      (t1.value == t2.value) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right)
  }

  /**
    * 迭代
    *
    * @param root
    * @return
    */
  def isSymmetric2(root: TreeNodeScala): Boolean = {

    val stack = new util.Stack[TreeNodeScala]()
    if (root != null) {
      stack.add(root.left)
      stack.add(root.right)
    }
    var s1 = true
    var result = true
    var flag = true
    while (!stack.isEmpty && s1) {
      val a: TreeNodeScala = stack.pop()
      val b = stack.pop()
      if (a == null && b == null) {
        flag = false
      }
      if (flag) {
        if (a.value == b.value && a != null && b != null) {
          stack.add(a.left)
          stack.add(b.right)
          stack.add(a.right)
          stack.add(b.left)
        } else {
          s1 = false
          result = false
        }
      }
    }
    result
  }


}
