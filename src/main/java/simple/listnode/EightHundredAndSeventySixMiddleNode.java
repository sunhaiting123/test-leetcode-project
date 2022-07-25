package simple.listnode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 876. 链表的中间结点
 * @author: sunhaiting
 * @create: 2020-06-17 10:46
 **/
public class EightHundredAndSeventySixMiddleNode {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode node = middleNode(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(node);
        for(int i:arrayList){
            System.out.println(i);
        }


    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow =head;
        while (fast!=null && fast.next!=null){
            slow =slow.next;
            fast =fast.next.next;
        }
        return  slow;
    }
}
