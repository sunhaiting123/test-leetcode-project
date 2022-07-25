package simple.treeNode;

import common.TreeNode;

import java.util.Stack;

/**
 * @description: 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @author: sunhaiting
 * @create: 2020-05-14 17:26
 **/
public class OneHundredAndTenIsBalanced {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode5;
//        treeNode3.right = treeNode4;

        boolean balanced = isBalanced(treeNode1);
        System.out.println(balanced);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (Math.abs(height(left) - height(right)) > 1) {
                    return false;
                }
                stack.push(left);
                stack.push(right);
            }
        }
        return true;
    }


    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }


    /**
     *
     * @param root
     * @return
     */
//    public  static  boolean isBalanced2(TreeNode root){
//
//    }
}
