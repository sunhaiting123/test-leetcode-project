package com.test.treenode;

import common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-05-12 17:46
 **/
public class MinDepth {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
//        treeNode2.left=treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode4;
        int i = minDepth(treeNode1);
        System.out.println(i);

    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, 1));
        int depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();
            if (node.left == null && node.right == null) {
                depth = Math.min(depth, value);
            }

            if (node.left != null) stack.push(new Pair<>(node.left, value + 1));
            if (node.right != null) stack.push(new Pair<>(node.right, value + 1));
        }
        return depth;
    }
}
