package secondary.listNode;


import common.ListNode;

import java.util.ArrayList;


/**
 * @description: 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @author: sunhaiting
 * @create: 2020-03-31 14:47
 **/
public class SixtyOneRotateRight {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode node = rotateRight(listNode, 2);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(node);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;
        if (head.next == null) return head;
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        k = k % n;
        ListNode new_tail = head;
        for (int i = 0; i < n - k - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next =null;
        return new_head;
    }
}

