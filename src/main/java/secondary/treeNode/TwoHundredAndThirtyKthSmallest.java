package secondary.treeNode;

import common.TreeNode;

import java.util.Stack;

/**
 * @description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * @author: sunhaiting
 * @create: 2020-07-01 09:20
 **/
public class TwoHundredAndThirtyKthSmallest {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;
        int i = kthSmallest(treeNode5, 3);
        System.out.println(i);


    }


    /**
     * 二叉搜索树的中序遍历刚好是有序的
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int res = -1;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                count++;
                if (count == k) {
                    res = pop.value;
                    break;
                }
                root = pop.right;
            }
        }
        return res;
    }
}
