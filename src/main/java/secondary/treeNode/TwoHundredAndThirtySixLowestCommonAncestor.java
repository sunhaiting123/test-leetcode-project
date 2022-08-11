package secondary.treeNode;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @author: sunhaiting
 * @create: 2020-07-03 17:10
 **/
public class TwoHundredAndThirtySixLowestCommonAncestor {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode = lowestCommonAncestor(treeNode1, treeNode1, treeNode5);
        System.out.println(treeNode.value);
    }

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root,null);
        stack.push(root);
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
                //存储父节点
                map.put(pop.left, pop);
            }

            if (pop.right != null) {
                stack.push(pop.right);
                map.put(pop.right, pop);
            }

        }

        //将p节点的全部父节点都存入set中
        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (q != null) {
            //判断q的父节点是否在set中
            if (set.contains(q)) {
                break;
            }
            q = map.get(q);
        }

        return q;
    }
}
