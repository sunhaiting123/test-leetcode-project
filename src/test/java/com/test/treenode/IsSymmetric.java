package com.test.treenode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 对称二叉树
 * @author: sunhaiting
 * @create: 2020-05-12 18:08
 **/
public class IsSymmetric {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode4;


        boolean symmetric = isSymmetric(treeNode1);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
//        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);
//        stack.add(root.left);
//        stack.add(root.right);
        while (!queue.isEmpty()) {

            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
//            TreeNode a = stack.pop();
//            TreeNode b = stack.pop();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.value != b.value) return false;

//            stack.add(a.left);
//            stack.add(b.right);
//            stack.add(a.right);
//            stack.add(b.left);
            queue.add(a.left);
            queue.add(b.right);
            queue.add(a.right);
            queue.add(b.left);
        }
        return true;
    }
}
