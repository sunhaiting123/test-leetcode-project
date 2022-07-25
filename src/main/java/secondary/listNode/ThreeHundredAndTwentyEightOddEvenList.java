package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * @author: sunhaiting
 * @create: 2020-06-05 14:37
 **/
public class ThreeHundredAndTwentyEightOddEvenList {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = oddEvenList(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for(int i:arrayList){
            System.out.println(i);
        }
    }

    /**
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
