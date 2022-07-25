package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: Leetcode19. 删除链表的倒数第N个节点
 * @author: sunhaiting
 * @create: 2020-04-20 10:18
 **/
public class NineteenRemoveNthFromEnd {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = removeNthFromEnd(listNode, 2);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 设定双指针 p 和 q，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，
     * 那么删除掉 p 的下一个指针就完成了要求。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }

}
