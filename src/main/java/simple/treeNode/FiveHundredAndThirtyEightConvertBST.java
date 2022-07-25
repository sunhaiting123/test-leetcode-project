package simple.treeNode;

import common.TreeNode;

import java.util.Stack;

/**
 * @description: 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @author: sunhaiting
 * @create: 2020-07-29 10:12
 **/
public class FiveHundredAndThirtyEightConvertBST {
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

        TreeNode treeNode = convertBST(treeNode5);
        System.out.println(treeNode.value + "==" + treeNode.left.value + "===" + treeNode.right.value);
        System.out.println(treeNode.left.left.value + "==" + treeNode.left.right.value);
        System.out.println(treeNode.left.left.left.value);

    }

    /**
     * 迭代
     * 相当于二叉搜索树的中序遍历
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.value;
            node.value = sum;
            node = node.left;

        }
        return root;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    static int sum = 0;

    public static TreeNode convertBST2(TreeNode root) {

        if (root != null) {
            convertBST2(root.right);
            sum += root.value;
            root.value = sum;
            convertBST2(root.left);
        }
        return root;
    }
}
