package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-16 21:29
 **/
public class TwentyFiveReverseKGroup {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = reverseKGroup(listNode, 3);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);

        for(int i:arrayList){
            System.out.println(i);
        }
    }


    public static ListNode reverseKGroup(ListNode head, int m) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < m && end!=null; i++) end = end.next;
            if(end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return  pre;
    }
}
