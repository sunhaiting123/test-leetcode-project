package simple.treeNode

import java.util

import common.TreeNodeScala

/**
  *
  * @description: 100. 相同的树
  * @author: sunhaiting
  * @create: 2019-11-13 19:43
  **/
object OnehundredIsSameTree {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(1)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(3)
    //    treeNode1.right = treeNode2
    //    treeNode1.left = treeNode3

    val treeNode4 = new TreeNodeScala(1)
    val treeNode5 = new TreeNodeScala(2)
    val treeNode6 = new TreeNodeScala(3)
    //    treeNode4.right = treeNode5
    //    treeNode4.left = treeNode6

    val bool = isSameTree(treeNode1, treeNode4)
    val bool2 = isSameTree2(treeNode1, treeNode4)
    println(bool)
    println(bool2)
  }

  /**
    * 一、递归方法
    * 给定两个二叉树，编写一个函数来检验它们是否相同。
    * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    *
    * 时间复杂度 :
    * O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
    *
    * 空间复杂度 :
    * 最优情况（完全平衡二叉树）时为 O(log⁡(N))，
    * 最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。
    *
    * @param p
    * @param q
    * @return
    */
  def isSameTree(p: TreeNodeScala, q: TreeNodeScala): Boolean = {

    if (p == null && q == null) true
    else if (p == null || q == null) false
    else if (p.value != q.value) false
    else if (p.left == null &&
      q.left == null &&
      p.right == null &&
      q.right == null &&
      p.value == q.value) true
    else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)

  }

  /**
    * 迭代方法
    *
    * @param p
    * @param q
    * @return
    */
  def isSameTree2(p: TreeNodeScala, q: TreeNodeScala): Boolean = {
    //使用栈来保存p和q遍历的节点
    val stack = new util.Stack[TreeNodeScala]()
    stack.add(p)
    stack.add(q)
    var s1 = true
    var result = true
    var flag = true
    while (!stack.isEmpty && s1) {
      //首先比较当前的两个节点
      val a = stack.pop()
      val b = stack.pop()
      if (a == null && b == null) {
        flag = false
      }
      if (flag) {
        if (a != null && b != null && a.value == b.value) {
          stack.add(a.left)
          stack.add(b.left)
          stack.add(a.right)
          stack.add(b.right)
        } else {
          s1 = false
          result = false
        }
      }
    }
    result
  }

}
