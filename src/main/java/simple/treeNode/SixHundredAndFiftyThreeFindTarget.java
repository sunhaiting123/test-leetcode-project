package simple.treeNode;

import common.TreeNode;

import java.util.*;

/**
 * @description: 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * @author: sunhaiting
 * @create: 2021-05-18 10:03
 **/
public class SixHundredAndFiftyThreeFindTarget {
    public static void main(String[] args) {


    }


    /**
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.value)) {
                return true;
            }
            set.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }


    /**
     * @param root
     * @param list
     */
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

}
