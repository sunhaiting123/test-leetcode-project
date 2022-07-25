package simple.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 563. 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * @author: sunhaiting
 * @create: 2020-07-29 16:25
 **/
public class FiveHundredAndSixtyThreeFindTilt {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode7;

        int sum = findTilt(treeNode5);
        System.out.println(sum);
    }

    /**迭代
     * @param root
     * @return
     */
    public static int findTilt(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int s1 = 0, s2 = 0;
            if (node.left != null) {
                s1 = node.left.value;
                queue.add(node.left);
            }
            if (node.right != null) {
                s2 = node.right.value;
                queue.add(node.right);
            }
            int tmp = Math.abs(s1 - s2);
            sum += tmp;
        }
        return sum;
    }



    static int tilt;

    /**
     * 递归
     * @param root
     * @return
     */
    public static int findTilt2(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findTilt2(root.left);
        int rightSum = findTilt2(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.value;
    }
}

