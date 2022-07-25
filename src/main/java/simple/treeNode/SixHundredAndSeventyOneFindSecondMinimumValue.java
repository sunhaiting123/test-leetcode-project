package simple.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * @author: sunhaiting
 * @create: 2021-05-21 11:19
 **/
public class SixHundredAndSeventyOneFindSecondMinimumValue {
    public static void main(String[] args) {

    }


    //定义两个变量，存储第一小和第二小的值
    public static int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    //如果二叉树只有一个数字的话,意味着second没有被赋值,那么count等于0,输出-1;如果count 大于0 那么就输出second;
    public static int count = 0;

    /**
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return count == 0 ? -1 : second;
    }


    public static void helper(TreeNode root) {
        if (root == null) return;

        if (root.value < first) {
            second = first;
            first = root.value;
        } else if (root.value < second && root.value > first) {
            second = root.value;
            count++;
        }

        helper(root.left);
        helper(root.right);
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static int findSecondMinimumValue2(TreeNode root) {

        int min = root.value;
        int min2 = Integer.MAX_VALUE;
        boolean flag = false;
        List<TreeNode> queue = new ArrayList<>();
//        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
//            TreeNode node = queue1.poll();
            if (node.value < min) {
                min2 = min;
                min = node.value;
            }
            if (node.value < min2 && node.value > min) {
                min2 = node.value;
                flag = true;
            }

            if (node.left != null) {
                queue.add(node.left);

            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        if (flag) {
            return min2;
        } else {
            return -1;
        }

    }

}
