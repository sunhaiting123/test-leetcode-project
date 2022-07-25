package secondary.listNode;

import common.ListNode;

/**
 * @description: 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @author: sunhaiting
 * @create: 2020-06-05 22:47
 **/
public class OneHundredAndFortyTwoDetectCycle {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list3;
        ListNode listNode = detectCycle(list1);
        System.out.println(listNode.value);

    }

    /**
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode interNode = isNotCycle(head);
        if (interNode == null) return null;

        ListNode pt1 = head;
        ListNode pt2 = interNode;
        while (pt1 != pt2) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return pt1;


    }


    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public static ListNode isNotCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return slow;
        }
        return null;
    }
}
