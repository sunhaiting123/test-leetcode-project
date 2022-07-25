package simple.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 100.相同的树
 * @author: sunhaiting
 * @create: 2020-05-09 11:05
 **/
public class OneHundredIsSameTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(4);
        treeNode4.right = treeNode5;
        treeNode4.left = treeNode6;
        boolean sameTree = isSameTree2(treeNode1, treeNode4);
        System.out.println(sameTree);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();

        stack.add(p);
        stack.add(q);

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.value != node2.value) return false;
            stack.push(node1.left);
            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
        }
        return true;
    }


    public static boolean isSameTree2(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(p);
        queue.add(q);

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
