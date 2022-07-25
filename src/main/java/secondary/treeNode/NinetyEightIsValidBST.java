package secondary.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author: sunhaiting
 * @create: 2020-04-12 23:08
 **/
public class NinetyEightIsValidBST {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode5;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode5;
        boolean validBST = isValidBST3(treeNode4);
        System.out.println(validBST);

    }

    /**
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 前序遍历递归
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public static boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        int value = node.value;
        if (node.value <= lower) return false;
        if (node.value >= upper) return false;
        if (!dfs(node.left, lower, value)) return false;
        if (!dfs(node.right, value, upper)) return false;
        return true;
    }




    static LinkedList<TreeNode> stack = new LinkedList();
    static LinkedList<Integer> uppers = new LinkedList();
    static LinkedList<Integer> lowers = new LinkedList();

    public static void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static boolean isValidBST3(TreeNode root) {
        Integer lower = null, upper = null, value;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            value = root.value;
            if (lower != null && value <= lower) return false;
            if (upper != null && value >= upper) return false;
            update(root.right, value, upper);
            update(root.left, lower, value);
        }
        return true;
    }

}
