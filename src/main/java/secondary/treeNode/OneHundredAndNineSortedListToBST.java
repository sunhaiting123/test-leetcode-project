package secondary.treeNode;

import common.ListNode;
import common.TreeNode;

/**
 * @description: 109. 有序链表转换二叉搜索树
 * *              给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author: sunhaiting
 * @create: 2020-04-27 11:50
 **/
public class OneHundredAndNineSortedListToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ListNode listNode = ListNode.arrayToListNode(nums);
        TreeNode treeNode = sortedListToBST(listNode);
        System.out.println(treeNode.value + "===" + treeNode.left.value + "===" + treeNode.right.value);

    }

    /**
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        return binarySearch(head, null);

    }

    private static TreeNode binarySearch(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.value);
        node.left = binarySearch(head, slow);
        node.right = binarySearch(slow.next, tail);
        return node;
    }
}
