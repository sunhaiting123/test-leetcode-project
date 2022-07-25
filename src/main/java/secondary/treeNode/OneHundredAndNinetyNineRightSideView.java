package secondary.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 199. 二叉树的右视图
 * *                 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author: sunhaiting
 * @create: 2020-05-08 11:12
 **/
public class OneHundredAndNinetyNineRightSideView {
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

        List<Integer> list = rightSideView2(treeNode1);
        for (int i : list) {
            System.out.println(i);
        }
    }

    /**
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;

                TreeNode node = queue.poll();
                if (count == 0) {
                    list.add(node.value);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

        }
        return list;
    }


    public static List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    list.add(node.value);
                }
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }
        return list;
    }
}
