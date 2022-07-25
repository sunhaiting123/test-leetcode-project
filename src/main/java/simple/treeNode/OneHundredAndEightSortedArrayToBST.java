package simple.treeNode;

import common.TreeNode;

/**
 * @description: 108. 将有序数组转换为二叉搜索树
 * *               将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * *               本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author: sunhaiting
 * @create: 2020-06-11 11:08
 **/
public class OneHundredAndEightSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums ={-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode.value+","+treeNode.left.value+","+treeNode.right.value);
        System.out.println(treeNode.left.left.value+","+treeNode.right.left.value);



    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return initTree(nums, 0, nums.length);
    }

    private static TreeNode initTree(int[] nums, int left, int right) {
        //递归终止条件
        if (left == right) return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = initTree(nums, left, mid);
        node.right = initTree(nums, mid + 1, right);

        return node;
    }

}



