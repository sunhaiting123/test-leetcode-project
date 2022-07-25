package common;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-11 22:31
 **/
public class TreeNode {
   public   int value;
   public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        value = x;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


}
