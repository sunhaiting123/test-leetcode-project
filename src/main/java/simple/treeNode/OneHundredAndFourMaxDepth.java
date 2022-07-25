package simple.treeNode;

import common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * @description: 104:二叉树的最大深度
 * @author: sunhaiting
 * @create: 2020-04-24 09:57
 **/
public class OneHundredAndFourMaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
//        int i = maxDepth(treeNode1);
        int i = minDepth(treeNode1);
        System.out.println(i);
    }


    /**
     * 最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode treeNode = pop.getKey();
            Integer value = pop.getValue();
            if (treeNode != null) {
                depth = Math.max(depth, value);
                if (treeNode.left != null) stack.add(new Pair<>(treeNode.left, depth + 1));
                if (treeNode.right != null) stack.add(new Pair<>(treeNode.right, depth + 1));
            }
        }
        return depth;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {

        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.add(new Pair<>(root, 1));
        int minDepth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode key = pop.getKey();
            Integer value = pop.getValue();
            if (key.left == null && key.right == null) {
                minDepth = Math.min(minDepth, value);
            }

            if (key.left != null) stack.add(new Pair<>(key.left, value + 1));
            if (key.right != null) stack.add(new Pair<>(key.right, value + 1));

        }
        return minDepth;
    }
}
