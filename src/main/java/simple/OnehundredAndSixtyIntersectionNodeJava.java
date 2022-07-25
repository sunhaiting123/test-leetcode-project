package simple;

import common.ListNode;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-01-08 10:08
 **/
public class OnehundredAndSixtyIntersectionNodeJava {
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
        list5.next = list2;


//        int[] arr1 = {4,2,8,4,5,6};
//        int[] arr2 = {5,0,8,4,5,6};
//        ListNode node1 = ListNode.arrayToListNode(arr1);
//        ListNode node2 = ListNode.arrayToListNode(arr2);

        ListNode intersectionNode = getIntersectionNode(node1, node2);
        System.out.println(intersectionNode.value+"==="+intersectionNode.next.value+"==="+intersectionNode.next.next.value);


    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
