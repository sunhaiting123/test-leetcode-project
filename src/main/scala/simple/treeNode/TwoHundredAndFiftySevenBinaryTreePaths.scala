package simple.treeNode

import java.util

import common.TreeNodeScala

import scala.collection.JavaConverters._

/**
  *
  * @description: 257. 二叉树的所有路径
  * @author: sunhaiting
  * @create: 2020-01-09 11:42
  **/
object TwoHundredAndFiftySevenBinaryTreePaths {
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

    val strings: List[String] = binaryTreePaths(treeNode1)
    println(strings.toBuffer)
  }

  /**
    * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
    * 说明: 叶子节点是指没有子节点的节点。
    * 输入:
    *
    * 1
    * / \
    * 2 3
    * \
    * 5
    * 输出: ["1->2->5", "1->3"]
    * 递归
    *
    * @param root
    * @return
    */
  def binaryTreePaths(root: TreeNodeScala): List[String] = {
    val paths = new util.LinkedList[String]()
    if (root != null) {
      val node_stack = new util.Stack[TreeNodeScala]()
      val path_stack = new util.Stack[String]()
      node_stack.add(root)
      path_stack.add(root.value.toString)

      while (!node_stack.isEmpty) {
        val node = node_stack.pop()
        val path = path_stack.pop()
        if (node.left == null && node.right == null) {
          paths.add(path)
        }
        if (node.left != null) {
          node_stack.add(node.left)
          path_stack.add(path + "->" + node.left.value.toString)
        }
        if (node.right != null) {
          node_stack.add(node.right)
          path_stack.add(path + "->" + node.right.value.toString)
        }
      }
    }
    paths.asScala.toList
  }


  /**
    * 递归
    *
    * @param root
    * @return
    */
  //  def binaryTreePaths2(root: TreeNode): List[String] = {
  //    val paths = new util.LinkedList[String]()
  //    if (root != null) construct_paths(root, "", paths)
  //    paths.asScala.toList
  //  }
  //
  //
  //  def construct_paths(root: TreeNode, path: String, paths: util.LinkedList[String]): Unit = {
  //
  //
  //    if (root != null) {
  //      var path1 = path
  //      path1 = path1 + root.value.toString
  //      if (root.left == null && root.right == null) {
  //        paths.add(path1)
  //      } else {
  //        path1 = path1 + "->"
  //        if (root.left != null) construct_paths(root.left, path1, paths)
  //        if (root.right != null) construct_paths(root.left, path1, paths)
  //      }
  //    }
  //  }


  //  public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
  //    if (root != null) {
  //      path += Integer.toString(root.val);
  //      if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
  //        paths.add(path);  // 把路径加入到答案中
  //      else {
  //        path += "->";  // 当前节点不是叶子节点，继续递归遍历
  //        construct_paths(root.left, path, paths);
  //        construct_paths(root.right, path, paths);
  //      }
  //    }
  //  }
  //
  //  public List<String> binaryTreePaths(TreeNode root) {
  //    LinkedList<String> paths = new LinkedList();
  //    construct_paths(root, "", paths);
  //    return paths;
  //  }

}
