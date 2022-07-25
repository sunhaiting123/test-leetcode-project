package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @author: sunhaiting
 * @create: 2020-04-10 15:36
 **/
public class EightyTwoDeleteDuplicates {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 3, 4, 4, 5,6};
//        int[] arr = {1, 2, 2, 3, 3};

        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = deleteDuplicates(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.value == cur.next.next.value) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.value == temp.next.value) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}
