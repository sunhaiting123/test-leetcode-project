package secondary.treeNode;

import common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * @author: sunhaiting
 * @create: 2020-07-30 15:47
 **/
public class SixHundredAndTwentyThreeAddOneRow {
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

        TreeNode treeNode = addOneRow(treeNode1, 9, 3);
        System.out.println(treeNode.left.left.value+"=="+treeNode.left.right.value);
    }


    /**
     * @param root
     * @param v
     * @param d
     * @return
     */
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else {
            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(root, 1));
            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode treeNode = pair.getKey();
                Integer depth = pair.getValue();

                if (depth == d - 1) {
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;

                    treeNode.left = new TreeNode(v);
                    treeNode.right = new TreeNode(v);
                    treeNode.left.left = left;
                    treeNode.right.right = right;
                } else {
                    if (treeNode.left != null) {
                        queue.add(new Pair<>(treeNode.left, depth + 1));
                    }
                    if (treeNode.right != null) {
                        queue.add(new Pair<>(treeNode.right, depth + 1));
                    }
                }
            }
            return root;
        }
    }
}
