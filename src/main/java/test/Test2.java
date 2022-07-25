package test;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-05-27 15:20
 **/
public class Test2 {
    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            if (list.size() != 0) {
                while (true) {
                    if (list.get(list.size() - 1).left == node || list.get(list.size() - 1).right == node) {
                        break;
                    } else {
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
