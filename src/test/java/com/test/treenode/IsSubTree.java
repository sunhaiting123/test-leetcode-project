package com.test.treenode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 572.判断一个树是否包含另一个子树
 * @author: sunhaiting
 * @create: 2020-05-13 23:41
 **/
public class IsSubTree {
    public static void main(String[] args) {



    }

    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return isSameTree(root1, root2) || isSubTree(root1.left, root2) || isSubTree(root1.right, root2);

    }


    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.value != node2.value) return false;
            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }

        return true;
    }


}

