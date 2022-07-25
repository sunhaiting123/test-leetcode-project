package simple.listnode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: Leetcode206. 反转链表
 * @author: sunhaiting
 * @create: 2020-04-17 11:48
 **/
public class TwoHundredAndSixReverseList {
    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = reverseList(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for(int i :arrayList){
            System.out.println(i);
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }
}
