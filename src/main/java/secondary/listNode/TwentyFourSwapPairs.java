package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: Leetcode24. 两两交换链表中的节点
 * @author: sunhaiting
 * @create: 2020-04-20 10:59
 **/
public class TwentyFourSwapPairs {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = swapPairs(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode firstTmp = pre.next;
            ListNode secondTmp = pre.next.next;
            //交换
            //链接
            firstTmp.next = secondTmp.next;
            secondTmp.next = firstTmp;
            pre.next = secondTmp;

            pre = firstTmp;

        }

        return dummy.next;
    }
}
