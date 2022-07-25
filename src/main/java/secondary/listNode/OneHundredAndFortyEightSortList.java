package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description:148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author: sunhaiting
 * @create: 2020-06-06 11:45
 **/
public class OneHundredAndFortyEightSortList {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 1, 4, 2};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = sortList(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }

        if (left != null) {
            res.next = left;
        } else {
            res.next = right;
        }
        return dummy.next;
    }

}
