package simple.treeNode;

import common.TreeNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @description: 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * @author: sunhaiting
 * @create: 2020-07-30 10:20
 **/
public class SixHundredAndSixTree2str {
    public static void main(String[] args) {
        /**
         *      * ****** 1
         *      * ****  / \
         *      * *****2  3
         *      * **** /\  \
         *      * ****4 5  6
         *      * *** /\
         *      * ***7 8
         */
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

        String s = tree2str(treeNode1);
        System.out.println(s);

    }

    /**
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * 输出: "1(2(4))(3)"
     * 原本将是“1(2(4)())(3())”，
     *
     * 迭代
     * @param root
     * @return
     */
    public static String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuffer buffer = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
             root = stack.peek();
            if (set.contains(root)) {
                stack.pop();
                buffer.append(")");
            } else {
                set.add(root);
                buffer.append("(" + root.value);

                if (root.left == null && root.right != null) {
                    buffer.append("()");
                }
                if (root.right != null) {
                    stack.push(root.right);
                }

                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return buffer.substring(1, buffer.length() - 1);
    }


}
