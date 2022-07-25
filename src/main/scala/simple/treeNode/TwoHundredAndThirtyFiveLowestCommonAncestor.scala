package simple.treeNode

import common.TreeNodeScala

/**
  *
  * @description: 235. 二叉搜索树的最近公共祖先
  * @author: sunhaiting
  * @create: 2020-01-07 16:19
  **/
object TwoHundredAndThirtyFiveLowestCommonAncestor {
  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNodeScala(6)
    val treeNode2 = new TreeNodeScala(2)
    val treeNode3 = new TreeNodeScala(8)
    val treeNode4 = new TreeNodeScala(0)
    val treeNode5 = new TreeNodeScala(4)
    val treeNode6 = new TreeNodeScala(7)
    val treeNode7 = new TreeNodeScala(9)
    val treeNode8 = new TreeNodeScala(3)
    val treeNode9 = new TreeNodeScala(5)
    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode3.left = treeNode6
    treeNode3.right = treeNode7
    treeNode5.left = treeNode8
    treeNode5.right = treeNode9

    val node = lowestCommonAncestor(treeNode1, treeNode4, treeNode5)
    println(node.value)

  }

  /**
    * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    * 示例 1:
    * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    * 输出: 6
    * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
    *
    *
    * 递归
    *
    * @param root
    * @param p
    * @param q
    * @return
    */
  def lowestCommonAncestor(root: TreeNodeScala, p: TreeNodeScala, q: TreeNodeScala): TreeNodeScala = {
    val pValue = p.value
    val qValue = q.value
    val rootValue = root.value

    if (pValue > rootValue && qValue > rootValue) lowestCommonAncestor(root.right, p, q)
    else if (pValue < rootValue && qValue < rootValue) lowestCommonAncestor(root.left, p, q)
    else root
  }

  /**
    * 迭代
    *
    * @param root
    * @param p
    * @param q
    * @return
    */
  def lowestCommonAncestor2(root: TreeNodeScala, p: TreeNodeScala, q: TreeNodeScala): TreeNodeScala = {
    var result: TreeNodeScala = null
    var flag = true
    var root1 = root
    val pValue = p.value
    val qValue = q.value
    while (root1 != null && flag) {
      val rootValue = root1.value
      if (pValue > rootValue && qValue > rootValue) {
        root1 = root1.right
      } else if (pValue < rootValue && qValue < rootValue) {
        root1 = root1.left
      } else {
        flag = false
        result = root1
      }
    }
    result
  }
}
