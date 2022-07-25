package simple.treeNode;

import common.TreeNode;

import java.util.*;

/**
 * @description: 107. 二叉树的层次遍历 II
 * @author: sunhaiting
 * @create: 2020-04-24 11:17
 **/
public class OneHundredAndSevenLevelOrderBottom {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        List<List<Integer>> lists = levelOrderBottom(treeNode1);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println("======");
        }
    }

    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                list.add(node.value);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            System.out.println("----" + list.size());
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}

//}

