package simple.treeNode;

import common.TreeNode;

/**
 * @description: 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @author: sunhaiting
 * @create: 2020-07-17 16:26
 **/
public class FiveHundredAndThirtyGetMinimumDifference {
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
        int minimumDifference = getMinimumDifference(treeNode3);
        System.out.println(minimumDifference);


    }

    static int min = Integer.MAX_VALUE;
    static TreeNode pre = null;

    /**
     * 中序遍历是有序的
     *
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {

        mid(root);
        return min;


    }

    private static void mid(TreeNode root) {
        if (root == null) return;

        mid(root.left);
        if (pre != null) {
            min = Math.min(min, root.value - pre.value);
        }

        //保留前一个节点
        pre = root;
        mid(root.right);
    }
}
