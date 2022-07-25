package secondary.treeNode;

import common.TreeNode;

import java.util.*;

/**
 * @description: 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @author: sunhaiting
 * @create: 2020-04-15 21:44
 **/
public class OneHundredAndThreeZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(11);
        TreeNode treeNode6 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;

        List<List<Integer>> lists = zigzagLevelOrder(treeNode1);
        for(List<Integer> list: lists){
            for (int i:list){
                System.out.println(i);
            }
            System.out.println("======");
        }

    }


    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 返回：
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();
        //存储右节点到左节点的顺序
        Stack<TreeNode> stack1 = new Stack<>();
        //存储左节点到右节点的顺序
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            TreeNode node ;
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    node = stack1.pop();
                    temp.add(node.value);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                res.add(temp);
            } else {
                while (!stack2.isEmpty()) {
                    node = stack2.pop();
                    temp.add(node.value);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                res.add(temp);
            }
        }
        return res;
    }
}
