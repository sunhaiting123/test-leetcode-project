package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author: sunhaiting
 * @create: 2020-06-05 23:11
 **/
public class OneHundredAndFortyThreeReorderList {
    public static void main(String[] args) {

        int[] arr ={1,2,3,4,5,6};
        ListNode listNode = ListNode.arrayToListNode(arr);
        reorderList(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
        for(int i:arrayList){
            System.out.println(i);
        }
    }

    /**
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow.next;
        //断开前后两个链表
        slow.next = null;
         pre = reverse(pre);


        //链表节点依次连接
        while (pre!=null){
            ListNode tmp = pre.next;
            pre.next=head.next;
            head.next=pre;
            head=pre.next;
            pre =tmp;
        }



    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;

        }
        return pre;
    }
}
