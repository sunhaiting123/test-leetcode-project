package secondary.treeNode;

import common.TreeNode;

import java.util.*;

/**
 * @description: 二叉树遍历：
 * * * **1
 * ****  / \
 * *****2  3
 * **** /\  \
 * ****4 5  6
 * *** /\
 * ***7 8
 * 前序遍历：1  2  4  5  7  8  3  6
 * 中序遍历：7  4  8  2  5  1  3  6
 * 后序遍历：4  7  8  5  2  6  3  1
 * 层次遍历：1  2  3  4  5  6  7  8
 * @author: sunhaiting
 * @create: 2019-11-14 17:54
 **/
public class OnehundredAndTwoLevelOrderJava {
    public static void main(String[] args) {

    }

    /**
     * 【迭代】
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * 层次遍历（从前到后）
     *
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            int cnt = queue.size();
//            for (int i = 0; i < cnt; i++) {
//                TreeNode node = queue.poll();
//                // System.out.println(node.val);
//                tmp.add(node.value());
//                if (node.left() != null) queue.add(node.left());
//                if (node.right() != null) queue.add(node.right());
//            }
//            res.add(tmp);
//        }
//        return res;
//    }

    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 返回其自底向上的层次遍历为：
     * <p>
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                // System.out.println(node.val);
                tmp.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        //将集合反转
        Collections.reverse(res);
        return res;
    }

    /**
     * 递归
     */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.value);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }


    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public String readLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            result.append(curNode.value);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return result.toString();
    }

    /**
     * 前序遍历
     * * * ** 1
     * ****  / \
     * *****2  3
     * **** /\  \
     * ****4 5  6
     * *** /\
     * ***7 8
     * 前序遍历：1  2  4  5  7  8  3  6
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    /**
     * 中序遍历
     * * * * ** 1
     * * ****  / \
     * * *****2  3
     * * **** /\  \
     * * ****4 5  6
     * * *** /\
     * * ***7 8
     * * * 中序遍历：7 4 8 2 5 1 3 6
     *
     * @param root
     */
    public List<Integer> inOrderTraverse1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode pNode = root;
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.value);
                pNode = node.right;
            }
        }
        return result;
    }


}
