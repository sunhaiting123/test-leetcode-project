package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * @author: sunhaiting
 * @create: 2020-06-09 17:50
 **/
public class FourHundredAndFortyFiveAddTwoNumbers {
    public static void main(String[] args) {

        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = ListNode.arrayToListNode(arr1);
        ListNode l2 = ListNode.arrayToListNode(arr2);

        ListNode listNode = addTwoNumbers2(l1, l2);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 翻转链表方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int i = node1 == null ? 0 : node1.value;
            int j = node2 == null ? 0 : node2.value;
            int num = (i + j + carry) % 10;

            ListNode node = new ListNode(num);
            cur.next = node;
            cur = node;
            carry = (i + j + carry) / 10;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        if (carry > 0) cur.next = new ListNode(carry);
        return reverse(dummy.next);

    }


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


    /**
     * 借助栈
     *
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.value);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.value);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int i = stack1.isEmpty() ? 0 : stack1.pop();
            int j = stack2.isEmpty() ? 0 : stack2.pop();

            int num = (i + j + carry) % 10;
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = node;

            carry = (i + j + carry) / 10;
        }
        return dummy.next;

    }
}
