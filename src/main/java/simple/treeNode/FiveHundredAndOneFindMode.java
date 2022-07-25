package simple.treeNode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2]
 * 返回[2].
 * @author: sunhaiting
 * @create: 2020-07-14 15:39
 **/
public class FiveHundredAndOneFindMode {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode6.left = treeNode4;
        treeNode6.right = treeNode9;
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode5;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode9.left = treeNode8;
        treeNode9.right = treeNode10;
        treeNode8.left = treeNode7;

//        midTraversal(treeNode6);
        int[] mode = findMode(treeNode6);
        for(int arr:mode){
            System.out.println(arr);
        }


    }


    static int maxCount;
    static int curCount;
    static TreeNode pre;
    static List<Integer> list;

    /**
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        list = new ArrayList<>();
        // 这里设置为1是因为 在递归中 BST中最左边的结点被跳过了，作为初状态 该结点值出现一次，记录的出现最多次数一开始也为1
        maxCount = 1;
        curCount = 1;
        midTraversal(root);
        // 最右端结点的处理，从递归中看，最后一个结点与前一个结点相等只更新了curCount的值；不相等则只考虑到倒数第二个结点。
        if (curCount > maxCount) {
            return new int[]{pre.value};
        } else if (curCount == maxCount) {
            list.add(pre.value);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * 中序遍历
     *
     * @param root
     */
    public static void midTraversal(TreeNode root) {
        if (root == null) return;
        midTraversal(root.left);
        if (pre != null) {
            //说明上一个值的结点数量已经统计完成 要看出现次数的情况
            if (pre.value != root.value) {
                if (curCount > maxCount) {
                    // 出现次数更多，清空之前的出现少的数，更新最大出现次数
                    maxCount = curCount;
                    list.clear();
                    list.add(pre.value);
                } else if (curCount == maxCount) {
                    list.add(pre.value);
                }
                //当前值与上一个节点值不同，重新计数
                curCount = 1;

            } else {
                curCount++;
            }
        }
        pre = root;
        midTraversal(root.right);

    }
}
