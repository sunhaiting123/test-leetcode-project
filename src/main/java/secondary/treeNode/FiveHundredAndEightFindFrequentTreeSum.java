package secondary.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description: 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * @author: sunhaiting
 * @create: 2020-07-17 11:30
 **/
public class FiveHundredAndEightFindFrequentTreeSum {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(-5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int[] frequentTreeSum = findFrequentTreeSum(treeNode1);
        for(int i:frequentTreeSum){
            System.out.println(i);
        }

    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int max = 0;

    /**
     * 出现次数最多的子树元素和
     *
     * @param root
     * @return
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        findSum(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * @param root
     * @return
     */
    public static int findSum(TreeNode root) {
        if (root == null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        int sum = root.value + left + right;
        //将结果放入HashMap中，并计算出出现的最多次数
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
