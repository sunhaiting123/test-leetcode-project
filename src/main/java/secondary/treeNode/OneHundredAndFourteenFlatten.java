package secondary.treeNode;

import common.TreeNode;

/**
 * @description: 114. 二叉树展开为链表
 * @author: sunhaiting
 * @create: 2020-05-25 18:17
 **/
public class OneHundredAndFourteenFlatten {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        flatten(treeNode1);

        System.out.println(treeNode1.value+","+treeNode1.right.value+","+treeNode1.right.right.value);
        System.out.println(treeNode1.right.right.right.value+","+treeNode1.right.right.right.right.value+","+treeNode1.right.right.right.right.right.value);

    }

    /**
     * 相当于二叉树的前序遍历
     * @param root
     */
    public static void flatten(TreeNode root) {
        while (root!=null){

            if(root.left==null){
                root =root.right;
            }else {
                //找到左子树的最右侧节点
                TreeNode pre = root.left;
                while (pre.right!=null){
                    pre=pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right =root.right;
                // 将左子树插入到右子树的地方
                root.right=root.left;
                root.left=null;
                // 考虑下一个节点
                root =root.right;

            }
        }
    }
}
