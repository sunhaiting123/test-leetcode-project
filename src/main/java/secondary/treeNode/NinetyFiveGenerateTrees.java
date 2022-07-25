package secondary.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @author: sunhaiting
 * @create: 2020-04-12 16:57
 **/
public class NinetyFiveGenerateTrees {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode tree : treeNodes) {
            System.out.println(tree.value);
        }


    }

    /**
     * 输入: 3
     * 输出:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     *
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {

        List<TreeNode>[] dp = new ArrayList[n + 1];
        // 如果left或right为0，就会出现空指针异常。
        dp[0] = new ArrayList<>();
        if (n == 0) return dp[0];
        // 如果不加null，那么后面当left或right为0时，就不会执行for循环。而一旦left不执行，right也会被跳过。
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            //把每个数字作为根节点，求出左子树，右子树所有的可能
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                  /*
                    假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，右边也有两个节点4,5。所以还去dp[2]里面找。
                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
                    我们不妨将1,2加上root，你会发现正好是4,5。
                    所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
                    但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
                */
                // 如果dp[left]里有两种可能，dp[right]里有三种可能，那么总共有6种可能。
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        // 这个是每一种可能的root节点。
                        TreeNode newTree = new TreeNode(root);
                        // 左子树直接连接。
                        newTree.left = leftTree;
                        // 右子树创建一个新的树。
                        newTree.right = clone(root, rightTree);
                        dp[len].add(newTree);
                    }
                }
            }
        }
        return dp[n];
    }

    private static TreeNode clone(int value, TreeNode root) {
        if (root == null) return null;
        TreeNode tree = new TreeNode(value + root.value);
        tree.left = clone(value, root.left);
        tree.right = clone(value, root.right);
        return tree;

    }
}
