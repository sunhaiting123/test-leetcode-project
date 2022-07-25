package secondary.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 * @author: sunhaiting
 * @create: 2020-07-17 16:10
 **/
public class FiveHundredAndFifteenLargestValues {
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
        List<Integer> list = largestValues(treeNode1);
        for(int i:list){
            System.out.println(i);
        }
    }

    /**
     * @param root
     * @return
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.value > max) {
                    max = node.value;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(max);
        }

        return list;
    }

}
