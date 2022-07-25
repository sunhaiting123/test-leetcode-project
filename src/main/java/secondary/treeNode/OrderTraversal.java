package secondary.treeNode;

import common.TreeNode;

import java.util.*;

/**
 * @description: 94. 二叉树的中序遍历
 * 前序遍历:打印-左-右
 * 中序遍历:左-打印-右
 * 后序遍历:左-右-打印
 * @author: sunhaiting
 * @create: 2020-04-11 22:31
 **/
public class OrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        List<Integer> list = inorderTraversal(treeNode1);
//        List<Integer> list = preorderTraversal(treeNode1);
//        List<Integer> list = readLevel(treeNode1);
//        List<Integer> list = PostOrderTraversal(treeNode1);
        for (int i : list) {
            System.out.println(i);
        }

    }

    /**
     * 顺序遍历
     * 层次遍历
     * * * ** 1
     * ****  / \
     * *****2  3
     * **** /\  \
     * ****4 5  6
     * *** /\
     * ***7 8
     * 顺序遍历：1  2  3  4  5  6  7  8
     *
     * @param root
     * @return
     */
    public static List<Integer> readLevel(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return null;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode treeNode = queue.remove();
            res.add(treeNode.value);
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        return res;
    }

    /**
     * 前序遍历:打印-左-右
     * 二叉树的前序遍历
     * * * ** 1
     * ****  / \
     * *****2  3
     * **** /\  \
     * ****4 5  6
     * *** /\
     * ***7 8
     * 前序遍历：1  2  4   7  8  5  3  6
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.value);
            if (treeNode.right != null) stack.push(treeNode.right);
            if (treeNode.left != null) stack.push(treeNode.left);
        }
        return res;
    }

    /**
     * 中序遍历:左-根-右
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
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.value);
                root = pop.right;
            }
        }
        return res;
    }


    /**
     * 后序遍历:左-右-打印
     * * * ** 1
     * ****  / \
     * *****2  3
     * **** /\  \
     * ****4 5  6
     * *** /\
     * ***7 8
     * 后序遍历：  7  8  4  5  2  6  3  1
     *
     * @param root
     * @return
     */
    public static List<Integer> PostOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        Stack<TreeNode> stack1 = new Stack<>();
        //构造一个中间栈，存储逆后序遍历的结果
        Stack<TreeNode> stack2 = new Stack<>();
        while (stack1.size() != 0 || root != null) {
            if (root != null) {
                stack1.push(root);
                //保存节点，相当于前序遍历,根-右-左
                stack2.push(root);
                root = root.right;
            } else {
                root = stack1.pop();
                root = root.left;
            }
        }
        while (stack2.size() != 0) {
            TreeNode node = stack2.pop();
            res.add(node.value);
        }
        return res;
    }

}
