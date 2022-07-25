package secondary.treeNode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 222. 完全二叉树的节点个数
 * @author: sunhaiting
 * @create: 2020-06-30 10:40
 **/
public class TwoHundredAndTwentyTwoCountNodes {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.right == null) return 2;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    /**
     * 顺序遍历-迭代
     *
     * @param root
     * @return
     */
    public static int countNodes2(TreeNode root) {
        /**
         * bfs
         *
         */
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return count;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                count++;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return count;
    }


    /**
     * 二分查找方式
     *
     * @param root
     * @return
     */
    public static int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int depth = getDepth2(root);
        if (depth == 0) return 1;
        int countNode = (int) Math.pow(2, depth) - 1;
        int lastnodes = (int) Math.pow(2, depth);
        int left = 1, right = lastnodes;
        int lastNum = 0;
        while (left <= right) {
            int privot = left + (right - left) / 2;
            if (isExist2(privot, depth, lastnodes, root)) {
                lastNum = privot;
                left = privot + 1;
            } else {
                right = privot - 1;
            }
        }
        return countNode + lastNum;
    }

    /**
     * 获取二叉树的深度，第一行从0开始
     * @param root
     * @return
     */
    public static int getDepth2(TreeNode root) {
        int dep = -1;
        TreeNode node = root;
        while (node != null) {
            dep++;
            node = node.left;
        }
        return dep;
    }

    /**
     * 判断节点是否存在
     * @param privot
     * @param depth
     * @param lastnode
     * @param root
     * @return
     */
    public static boolean isExist2(int privot, int depth, int lastnode, TreeNode root) {
        int left = 1, right = lastnode;
        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (privot <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
        }
        if (root == null) return false;
        return true;
    }
}

