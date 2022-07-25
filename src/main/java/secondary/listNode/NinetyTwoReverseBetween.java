package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * @author: sunhaiting
 * @create: 2020-04-11 19:11
 **/
public class NinetyTwoReverseBetween {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = reverseBetween(listNode, 3, 5);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode pre = null;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = pre, tail = cur;
        while (n > 0) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
            n--;
        }
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }
}
