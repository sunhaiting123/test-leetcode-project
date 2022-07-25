package test;

import common.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-05-27 10:43
 **/
public class Test1 {
    public static void main(String[] args) {

        Deque<Integer> stack1 = new LinkedList<>();
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
        stack1.push(4);
        System.out.println(stack1);

        Integer pop = stack1.pop();
        System.out.println(pop+ "==="+stack1);
//        Integer peek = stack1.peek();
//        System.out.println(peek+"===="+stack1);
        System.out.println(stack1.poll()+"===="+stack1);
//        System.out.println(stack1.pop()+"===="+stack1);


        Deque<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
//        System.out.println(queue);
        Integer remove = queue.pop();
//        System.out.println(remove+"==="+queue);


    }

    public static List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Pair<TreeNode, Integer>> s1 = new Stack<>();
        s1.push(new Pair<>(root, sum - root.value));

        Stack<List<Integer>> s2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.value);
        s2.push(list);
        while (s1.size() != 0) {
            Pair<TreeNode, Integer> pop = s1.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();

            List<Integer> pop1 = s2.pop();
            if (node.left == null && node.right == null && value == 0) {
                res.add(pop1);
            }

            if (node.left != null) {
                s1.push(new Pair<>(node, value - node.left.value));
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.addAll(pop1);
                arrayList.add(node.left.value);
                s2.push(arrayList);
            }
            if (node.right != null) {
                s1.push(new Pair<>(node, value - node.right.value));
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.addAll(pop1);
                arrayList.add(node.right.value);
                s2.push(arrayList);
            }
        }
        return res;
    }
}
