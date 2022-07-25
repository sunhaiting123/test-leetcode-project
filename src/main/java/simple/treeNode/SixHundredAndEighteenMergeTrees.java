package simple.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @author: sunhaiting
 * @create: 2020-05-14 13:23
 **/
public class SixHundredAndEighteenMergeTrees {
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

        TreeNode treeNode = mergeTrees(treeNode1, treeNode3);
        System.out.println(treeNode.value + "==" + treeNode.left.value + "==" + treeNode.right.value);
        System.out.println(treeNode.right.left.value + "==" + treeNode.right.right.value);
    }


    /**
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(t1);
        q2.add(t2);

        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1.left != null && n2.left != null) {
                q1.add(n1.left);
                q2.add(n2.left);
            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            if (n1.right != null && n2.right != null) {
                q1.add(n1.right);
                q2.add(n2.right);
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
            n1.value = n1.value + n2.value;

        }
        return t1;
    }
}
