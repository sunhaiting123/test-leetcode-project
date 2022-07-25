package secondary.treeNode;

import common.TreeNode;

import java.util.HashMap;

/**
 * @description: 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * @author: sunhaiting
 * @create: 2020-07-07 10:20
 **/
public class ThreeHundredAndThirtyThreeRob {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode111 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode99 = new TreeNode(9);
        treeNode9.left = treeNode1;
        treeNode9.right = treeNode2;
        treeNode1.right = treeNode5;
        treeNode5.right = treeNode11;
        treeNode11.right = treeNode111;
        treeNode111.right = treeNode99;
        int rob = rob3(treeNode9);
        System.out.println(rob);

    }


    /**
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * <p>
     * 暴力递归+最优子结构
     * 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱
     * 哪个组合钱多，就当做当前节点能偷的最大钱数。
     * 这就是动态规划里面的最优子结构
     *
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {
        if (root == null) return 0;

        int money = root.value;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }


    /**
     * @param root
     * @return
     */
    public static int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    /**
     * 将每一次的计算结果存储到hashMap中
     *
     * @param root
     * @param map
     * @return
     */
    private static int helper(TreeNode root, HashMap<TreeNode, Integer> map) {

        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int money = root.value;

        if (root.left != null) {
            money += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null) {
            money += helper(root.right.left, map) + helper(root.right.right, map);
        }
        int result = Math.max(money, helper(root.left, map) + helper(root.right, map));

        map.put(root, result);
        return result;
    }


    /**
     *  result[0]代表当前节点不偷，result[1]代表当前节点偷
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择自己不偷时能得到的钱 + 当前节点的钱数
     *
     * @param root
     * @return
     */
    public static int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);

    }

    private static int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.value;

        return result;
    }


}
