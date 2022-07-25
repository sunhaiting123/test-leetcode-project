package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * @author: sunhaiting
 * @create: 2020-04-10 18:01
 **/
public class EightySixPartition {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,4,2,2};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode partition = partition(listNode,3);
        ArrayList<Integer> result = ListNode.listNodeToArray(partition);
        for(int i :result){
            System.out.println(i);
        }

    }

    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(-1);
        ListNode before = before_head;
        ListNode after_head = new ListNode(-1);
        ListNode after = after_head;
        while (head != null) {
            if (head.value < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;

        return before_head.next;

    }
}
