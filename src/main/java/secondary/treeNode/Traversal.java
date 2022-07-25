package secondary.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-12 10:28
 **/
public class Traversal {
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
//        List<Integer> list = inorderTraversal(treeNode1);
//        List<Integer> list = preorderTraversal(treeNode1);
        List<Integer> list = postOrderTraversal(treeNode1);
        for (int i : list) {
            System.out.println(i);
        }
    }

    /**
     * 递归--前序遍历:根-左-右
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
        preHelper(root, res);
        return res;
    }


    public static void preHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.value);
            if (root.left != null) {
                preHelper(root.left, res);
            }
            if (root.right != null) {
                preHelper(root.right, res);
            }
        }

    }

    /**
     * 递归中序遍历:左-根-右
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
        inHelper(root, res);
        return res;
    }

    public static void inHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inHelper(root.left, res);
            }
            res.add(root.value);
            if (root.right != null) {
                inHelper(root.right, res);
            }
        }
    }


    /**
     * 后序遍历:左-右-根
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
    public static List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        postHelper(root, res);
        return res;
    }

    private static void postHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                postHelper(root.left, res);
            }
            if (root.right != null) {
                postHelper(root.right, res);
            }
            res.add(root.value);
        }
    }


}
