package simple.treeNode;

import common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * @description:
 * 题目：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author: sunhaiting
 * @create: 2022-05-26 13:27
 **/
public class OnehundredAndTwelveHasPathSumJava {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
//        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        boolean b = hasPathSum2(treeNode1, 10);
        System.out.println(b);
    }


    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum - root.value));
        while (stack.size() != 0) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();
            if (node.left == null && node.right == null) {
                if (value == 0) {
                    return true;
                }
                continue;
            }
            if (node.left != null) stack.push(new Pair<>(node.left, value - node.left.value));
            if (node.right != null) stack.push(new Pair<>(node.right, value - node.right.value));

        }
        return false;
    }
}
