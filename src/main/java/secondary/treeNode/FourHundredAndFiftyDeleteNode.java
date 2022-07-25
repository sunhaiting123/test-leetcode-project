package secondary.treeNode;

import common.TreeNode;

/**
 * @description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * @author: sunhaiting
 * @create: 2020-07-10 10:50
 **/
public class FourHundredAndFiftyDeleteNode {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode8.left = treeNode5;
        treeNode8.right = treeNode9;
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode6.right = treeNode7;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;

        TreeNode treeNode = deleteNode(treeNode8, 5);
        System.out.println(treeNode.value);
        System.out.println(treeNode.left.value);
        System.out.println(treeNode.right.value);
        System.out.println(treeNode.left.left.value);
        System.out.println(treeNode.left.right.value);
//        System.out.println(treeNode.left.left.left.value);


    }

    /**
     * 二叉搜索树的中序遍历的序列是递增排序的序列
     * 迭代
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        //找到要删除的节点
        while (cur != null && cur.value != key) {
            parent = cur;
            if (cur.value > key) {
                cur = cur.left;
            } else if (cur.value < key) {
                cur = cur.right;
            }
        }

        if (cur == null) return root;

        if (cur.left == null && cur.right == null) {
            //删除的节点不是根节点
            if (parent != null) {
                if (parent.left == cur) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                //整个树只有一个节点
                return null;
            }
            //左节点或者右节点其中有一个为null
        } else if (cur.left == null || cur.right == null) {
            TreeNode sub = cur.left == null ? cur.right : cur.left;
            cur.value = sub.value;
            cur.left = sub.left;
            cur.right = sub.right;
            sub.left = null;
            sub.right = null;
            //左右节点都不为null，找到左子树中的最大值，替换到key节点
        } else {
            TreeNode sub = cur.left;
            //右子树为null
            if (sub.right == null) {
                cur.left = sub.left;
                cur.value = sub.value;
                sub.left = null;
            } else {
                parent = sub;
                while (sub.right != null) {
                    parent = sub;
                    sub = sub.right;
                }
                parent.right = sub.left;
                cur.value = sub.value;
                sub.left = null;
            }
        }
        return root;

    }

    /**
     * 递归
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.value > key) root.left = deleteNode2(root.left, key);
        else if (root.value < key) root.right = deleteNode2(root.right, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.value = successor(root);
                root.right = deleteNode2(root.right, root.value);

            } else {
                root.value = predecessor(root);
                root.left = deleteNode2(root.left, root.value);
            }
        }
        return root;
    }


    /**
     * 找右子树的最小值
     *
     * @param root
     * @return
     */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.value;
    }

    /**
     * 找左子树的最大值
     *
     * @param root
     * @return
     */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.value;

    }
}
