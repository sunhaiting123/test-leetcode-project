package com.test.treenode;

import common.TreeNode;
import common.TreeNodeScala;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 二叉树最大深度
 * @author: sunhaiting
 * @create: 2020-05-12 17:41
 **/
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left=treeNode3;


        int i = maxDepth(treeNode1);
        System.out.println(i);
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
//        Queue<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();
            depth = Math.max(depth, value);

            if (node.left != null) stack.push(new Pair<>(node.left, depth + 1));
            if (node.right != null) stack.push(new Pair<>(node.right, depth + 1));
        }
        return depth;
    }
}
