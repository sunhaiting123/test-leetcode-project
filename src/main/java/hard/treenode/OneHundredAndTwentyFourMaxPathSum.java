package hard.treenode;

import common.TreeNode;

/**
 * @description: 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * @author: sunhaiting
 * @create: 2020-06-18 14:08
 **/
public class OneHundredAndTwentyFourMaxPathSum {
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
        int i = maxPathSum(treeNode1);
        System.out.println(i);
    }


    public static int res = Integer.MIN_VALUE;

    /**
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root) {

        if (root == null) return 0;

        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;

        //左子树贡献
        int left = Math.max(0, dfs(root.left));
        //右子树贡献
        int right = Math.max(0, dfs(root.right));

        res = Math.max(res, root.value + left + right);
        //返回当前节点的总贡献
        return root.value + Math.max(left, right);

    }
}
