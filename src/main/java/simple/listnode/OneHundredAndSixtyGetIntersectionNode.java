package simple.listnode;

import common.ListNode;

/**
 * @description: Leetcode160. 相交链表
 * @author: sunhaiting
 * @create: 2020-04-17 10:36
 **/
public class OneHundredAndSixtyGetIntersectionNode {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(8);
        ListNode list3 = new ListNode(4);
        ListNode list4 = new ListNode(5);
        node1.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;

        ListNode node2 = new ListNode(5);
        ListNode list5 = new ListNode(0);

        node2.next = list5;
        list5.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        ListNode intersectionNode = getIntersectionNode(node1, node2);
        System.out.println(intersectionNode.value);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = (ha != null) ? ha.next : headB;
            hb = (hb != null) ? hb.next : headA;
        }
        return ha;
    }
}
