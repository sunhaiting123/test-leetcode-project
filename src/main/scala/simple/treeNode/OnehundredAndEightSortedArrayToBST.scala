package simple.treeNode

import common.TreeNodeScala

/**
  *
  * @description: 108. 将有序数组转换为二叉搜索树
  *               将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
  *               本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
  * @author: sunhaiting
  * @create: 2020-01-01 12:00
  **/
object OnehundredAndEightSortedArrayToBST {
  def main(args: Array[String]): Unit = {
    val arr = Array(-10, -3, 0, 5, 9)
    val node = sortedArrayToBST(arr)
    println(node.value)
    println(node.left.value, node.right.value)
    println(node.left.left.value)
    println(node.right.left.value)

  }

  /**
    * 给定有序数组: [-10,-3,0,5,9],
    *
    * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
    * 0
    * / \
    * -3   9
    * /   /
    * -10  5
    *
    * 递归
    *
    * @param nums
    * @return
    */
  def sortedArrayToBST(nums: Array[Int]): TreeNodeScala = {
    initTree(nums, 0, nums.length-1)

  }

  def initTree(nums: Array[Int], left: Int, right: Int): TreeNodeScala = {
    if (left > right) {
      null
    } else if (left == right) {
      new TreeNodeScala(nums(left))
    }
    else {
      val mid: Int = left + (right - left) / 2
      val node = new TreeNodeScala(nums(mid))
      node.left = initTree(nums, left, mid)
      node.right = initTree(nums, mid + 1, right)
      node
    }
  }


  /**
    * 迭代
    *
    * @param nums
    * @return
    */
//  def sortedArrayToBST2(nums: Array[Int]): TreeNode = {
  //    if (nums.length == 0) {
  //      null
  //    } else {
  //      val rootStack = new util.Stack()
  //      val start =0
  //      val end =nums.length-1
  //      val mid = start+(end-start)/2
  //      val root = new TreeNode(nums(mid))
  //      rootStack.push()
  //    }
  //  }


  //  public TreeNode sortedArrayToBST(int[] nums) {
  //    if (nums.length == 0) {
  //      return null;
  //    }
  //    Stack<MyTreeNode> rootStack = new Stack<>();
  //    int start = 0;
  //    int end = nums.length;
  //    int mid = (start + end) >>> 1;
  //    TreeNode root = new TreeNode(nums[mid]);
  //    TreeNode curRoot = root;
  //    rootStack.push(new MyTreeNode(root, start, end));
  //    while (end - start > 1 || !rootStack.isEmpty()) {
  //      //考虑左子树
  //      while (end - start > 1) {
  //        mid = (start + end) >>> 1; //当前根节点
  //        end = mid;//左子树的结尾
  //        mid = (start + end) >>> 1;//左子树的中点
  //        curRoot.left = new TreeNode(nums[mid]);
  //        curRoot = curRoot.left;
  //        rootStack.push(new MyTreeNode(curRoot, start, end));
  //      }
  //      //出栈考虑右子树
  //      MyTreeNode myNode = rootStack.pop();
  //      //当前作为根节点的 start end 以及 mid
  //      start = myNode.start;
  //      end = myNode.end;
  //      mid = (start + end) >>> 1;
  //      start = mid + 1; //右子树的 start
  //      curRoot = myNode.root; //当前根节点
  //      if (start < end) { //判断当前范围内是否有数
  //        mid = (start + end) >>> 1; //右子树的 mid
  //        curRoot.right = new TreeNode(nums[mid]);
  //        curRoot = curRoot.right;
  //        rootStack.push(new MyTreeNode(curRoot, start, end));
  //      }
  //
  //    }

}
