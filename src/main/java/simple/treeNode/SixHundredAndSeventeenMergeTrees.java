package simple.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 617 :合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @author: sunhaiting
 * @create: 2021-05-12 10:21
 **/
public class SixHundredAndSeventeenMergeTrees {
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
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode4;


    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode treeNode = new TreeNode(t1.value + t2.value);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue.add(treeNode);
        queue1.add(t1);
        queue2.add(t2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode treeNode1 = queue1.poll();
            TreeNode treeNode2 = queue2.poll();

            TreeNode left1 = treeNode1.left;
            TreeNode right1 = treeNode1.right;
            TreeNode left2 = treeNode2.left;
            TreeNode right2 = treeNode2.right;

            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.value + left2.value);
                    node.left = left;
                    queue.add(left);
                    queue1.add(left1);
                    queue2.add(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }


            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.value + right2.value);
                    node.right = right;
                    queue.add(right);
                    queue1.add(right1);
                    queue2.add(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }
        return treeNode;
    }
}
