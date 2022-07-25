package secondary.treeNode;

import com.sun.org.apache.regexp.internal.REUtil;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * @author: sunhaiting
 * @create: 2020-07-17 15:23
 **/
public class FiveHundredAndThirteenFindBottomLeftValue {
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
//        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        int bottomLeftValue = findBottomLeftValue(treeNode1);
        System.out.println(bottomLeftValue);
    }


    /**
     * 找出最左面的数值，为应对不同结构的树结构，需要在遍历右分支时先把val存一下
     *
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        int target = root.value;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
                target = node.right.value;
            }

            if (node.left != null) {
                queue.add(node.left);
                target = node.left.value;
            }
        }
        return target;
    }
}
