package simple.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @author: sunhaiting
 * @create: 2020-07-08 11:58
 **/
public class FourHundredAndThirtySevenPathSum {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(-3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(-2);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.right=treeNode6;
        treeNode4.left=treeNode7;
        treeNode4.right=treeNode8;
        treeNode5.right=treeNode9;
        int i = pathSum(treeNode1, 8);
        System.out.println(i);


    }

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * @param root
     * @param sum
     * @return
     */
    public static int pathSum(TreeNode root, int sum) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            if (list.size() != 0) {
                while (true) {
                    // 如果当前节点是路径pathList的子节点，是左或者右节点，
                    //我们什么都不做break，随后把当前节点加入pathList
                    if (list.get(list.size() - 1).left == node || list.get(list.size() - 1).right == node) {
                        break;
                    } else {
                        //如果不是，我们就删除最后一个，一直找到当前节点的父节点
                        list.remove(list.size() - 1);
                    }
                }
            }
            list.add(node);
            int tmp = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                tmp += list.get(i).value;
                if (tmp == sum) {
                    count++;
                }
            }
        }
        return count;

    }
}
