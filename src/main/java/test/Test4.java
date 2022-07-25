package test;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-05-28 10:35
 **/
public class Test4 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);
        map.put(root, null);

        while (stack.size() != 0) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
                map.put(pop.left, pop);
            }

            if (pop.right != null) {
                stack.push(pop.right);
                map.put(pop.right, pop);
            }
        }

        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (map.get(q) != null) {
            if (set.contains(q)) {
                break;
            }
            q = map.get(q);
        }

        return q;
    }


    public static int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int depth = getDepth(root);
        if (depth == 0) return 1;
        int countNodes = (int) Math.pow(2, depth) - 1;
        int lastnode = (int) Math.pow(2, depth);
        int left = 1, right = lastnode;
        int lastnum = 0;
        while (left <= right) {
            int privot = left + (right - left) / 2;
            if (isExists(privot, depth, lastnode, root)) {
                lastnode = privot;
                left = privot + 1;
            } else {
                right = privot - 1;
            }
        }

        return countNodes + lastnum;
    }

    private static boolean isExists(int privot, int depth, int lastnode, TreeNode root) {
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


    public static int getDepth(TreeNode root) {
        int n = -1;
        while (root != null) {
            n++;
            root = root.left;
        }
        return n;
    }


    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int res = -1;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                count++;
                if (count == k) {
                    res = pop.value;
                    break;
                }
                root = root.right;
            }
        }
        return res;
    }


    public static int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        stack.push(root);
        stack1.push(0);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer num = stack1.pop();
            int cur = sum * 10 + pop.value;

            if (pop.left == null && pop.right == null) {
                sum += cur;
            }

            if (pop.left != null) {
                stack.push(pop.left);
                stack1.push(cur);
            }

            if (pop.right != null) {
                stack.push(pop.right);
                stack1.push(cur);
            }
        }

        return sum;
    }


    public static int res = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {

        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        res = Math.max(res, root.value + left + right);
        return root.value + Math.max(left, right);

    }
}
