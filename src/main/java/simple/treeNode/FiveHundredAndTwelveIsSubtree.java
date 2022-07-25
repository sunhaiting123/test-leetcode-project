package simple.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @author: sunhaiting
 * @create: 2020-05-14 14:42
 **/
public class FiveHundredAndTwelveIsSubtree {
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
        boolean subTree = isSubTree(treeNode1, treeNode3);
        System.out.println(subTree);
    }

    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return isSameTree(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }


    public static boolean isSameTree(TreeNode t1, TreeNode t2) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(t1);
        q.add(t2);
        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.value != n2.value) return false;

            q.add(n1.left);
            q.add(n2.left);
            q.add(n1.right);
            q.add(n2.right);
        }

        return true;
    }
}
