package simple.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: Leetocde257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @author: sunhaiting
 * @create: 2020-06-12 14:58
 **/
public class TwohundredAndFiftySevenBinaryTreePaths {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;

        List<String> strings = binaryTreePaths(treeNode1);
        for (String s : strings) {
            System.out.println(s);
        }

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> node_stack = new Stack<>();
        Stack<String> path_stack = new Stack<>();
        node_stack.push(root);
        path_stack.push(Integer.toString(root.value));

        while (!node_stack.isEmpty()) {
            TreeNode node = node_stack.pop();
            String path = path_stack.pop();
            if (node.left == null && node.right == null) {
                list.add(path);
            }

            if (node.left != null) {
                node_stack.push(node.left);
                path_stack.push(path + "->" + node.left.value);
            }
            if (node.right != null) {
                node_stack.push(node.right);
                path_stack.push(path + "->" + node.right.value);
            }
        }
        return list;

    }
}
