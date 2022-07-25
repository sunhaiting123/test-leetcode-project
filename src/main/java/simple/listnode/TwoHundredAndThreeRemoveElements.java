package simple.listnode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: Leetcode203. 移除链表元素
 * @author: sunhaiting
 * @create: 2020-04-17 10:53
 **/
public class TwoHundredAndThreeRemoveElements {
    public static void main(String[] args) {

        int[] arr = {1,1, 2, 3, 3, 4, 4};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = removeElements2(listNode, 1);

        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }

    }

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeElements(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!= null) {
            if (cur.value == k) {
                pre.next = cur.next ;
            } else {
                pre = pre.next;
            }
            cur =cur.next;
        }
        return dummy.next;
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeElements2(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        while (pre.next!= null) {
            if (pre.next.value == k) {
                pre.next = pre.next.next ;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }



}
