package com.test.treenode;

import common.ListNode;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-05-13 16:26
 **/
public class rotateRight {
    public static void main(String[] args) {

    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode pre = head;
        int n = 1;
        while (pre.next != null) {
            pre = pre.next;
            n++;
        }
        pre.next = head;

        ListNode new_tail = head;
        k = k % n;

        for (int i = 0; i < n - k - 1; i++) {
            new_tail = new_tail.next;
        }

        ListNode new_head = new_tail.next;
        new_tail.next = null;

        return new_head;
    }
}
