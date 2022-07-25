package secondary.treeNode;

import common.TreeNode;

/**
 * @description: 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * @author: sunhaiting
 * @create: 2020-05-15 22:36
 **/
public class SixHundredAndFiftyFourConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode treeNode = constructMaximumBinaryTree(nums);

        System.out.println(treeNode.value + "==" + treeNode.left.value + "===" + treeNode.right.value);
        System.out.println(treeNode.left.right.value + "==" + treeNode.left.right.right.value + "===" + treeNode.right.left.value);

    }

    /**
     *
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return construct(nums, 0, nums.length);
    }


    public static TreeNode construct(int[] nums, int l, int r) {
        if (l == r) return null;

        int max = maxArr(nums, l, r);
        TreeNode node = new TreeNode(nums[max]);
        node.left = construct(nums, l, max);
        node.right = construct(nums, max + 1, r);
        return node;


    }

    /**
     * 计算数组最大值所在的索引
     *
     * @param nums
     * @param m
     * @param n
     * @return
     */
    public static int maxArr(int[] nums, int m, int n) {

        int max = m;

        for (int i = m; i < n; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
