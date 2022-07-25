package simple.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @author: sunhaiting
 * @create: 2020-08-05 15:18
 **/
public class SixHundredAndThirtySevenAverageOfLevels {
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
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode4;
        List<Double> doubles = averageOfLevels(treeNode1);
        for(int i=0;i<doubles.size();i++){
            System.out.println(doubles.get(i));
        }
    }

    /**
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root==null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            double sum=0;
            int size =queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                sum += node.value;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(sum/size);
        }
    return  list;
    }
}
