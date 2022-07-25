package secondary.treeNode;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @author: sunhaiting
 * @create: 2020-05-23 11:43
 **/
public class OneHundredAndThirTeenPathSum {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        List<List<Integer>> lists = pathSum(treeNode1, 6);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println("=======");
        }

    }

    /**
     * 迭代
     *
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum2(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Pair<TreeNode, Integer>> stack1 = new Stack<>();
        stack1.push(new Pair<>(root, sum - root.value));

        Stack<List<Integer>> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.value);
        stack2.push(list);

        while (!stack1.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack1.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();

            List<Integer> pop1 = stack2.pop();
            if (node.left == null && node.right == null && value == 0) {
                res.add(pop1);
            }

            if (node.left != null) {
                stack1.add(new Pair<>(node.left, value - node.left.value));
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(pop1);
                list1.add(node.left.value);
                stack2.push(list1);
            }
            if (node.right != null) {
                stack1.add(new Pair<>(node.right, value - node.right.value));
                List<Integer> list2 = new ArrayList<>();
                list2.addAll(pop1);
                list2.add(node.right.value);
                stack2.push(list2);
            }

        }
        return res;
    }

    /**
     * 递归
     *
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        path(root, sum, list, tmp);

        return list;
    }

    private static void path(TreeNode root, int sum, List<List<Integer>> list, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }

        tmp.add(root.value);
        if (root.left == null && root.right == null && sum == root.value) {
            // 这里使用 new 的形式是因为初始化后,传进来的数据每次都是更新后的 tmp
            list.add(new ArrayList<>(tmp));
        }

        path(root.left, sum - root.value, list, tmp);
        path(root.right, sum - root.value, list, tmp);
        // 这里利用了回溯的思想:每次回退上一个节点再寻找另一条边的节点作为新路径
        tmp.remove(tmp.size() - 1);
    }


}
