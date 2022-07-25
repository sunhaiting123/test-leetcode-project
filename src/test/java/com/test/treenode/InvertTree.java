package com.test.treenode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 翻转二叉树
 * @author: sunhaiting
 * @create: 2020-05-12 18:02
 **/
public class InvertTree {


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        TreeNode treeNode = invertTree(treeNode1);

        System.out.println(treeNode.value + "=" + treeNode.left.value + "=" + treeNode.right.value);
    }


    public static TreeNode invertTree(TreeNode root) {

        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}

