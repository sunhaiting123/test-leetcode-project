package simple.listnode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 83. 删除排序链表中的重复元素
 * @author: sunhaiting
 * @create: 2020-04-17 09:33
 **/
public class EightyThreeDeleteDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = deleteDuplicates(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
