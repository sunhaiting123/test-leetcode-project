package secondary.treeNode;

import common.TreeNode;

import java.util.Stack;

/**
 * @description: 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: sunhaiting
 * @create: 2020-06-18 18:04
 **/
public class OneHundredAndTwentyNineSumNumbers {
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

        int i = sumNumbers2(treeNode1);
        System.out.println(i);
    }

    public static int sum = 0;

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        helper(root, 0);
        return sum;
    }

    private static void helper(TreeNode root, int father) {
        if (root == null) return;
        int cur = root.value + father * 10;

        if (root.left == null && root.right == null) {
            sum = sum + cur;
        }
        helper(root.left, cur);
        helper(root.right, cur);

    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static int sumNumbers2(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        nodeStack.push(root);
        numStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer num = numStack.pop();
            int cur = num * 10 + node.value;
            if (node.left == null && node.right == null) {
                sum += cur;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                numStack.push(cur);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                numStack.push(cur);
            }
        }
        return sum;
    }

}
