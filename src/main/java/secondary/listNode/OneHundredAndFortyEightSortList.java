package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description:148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author: sunhaiting
 * @create: 2020-06-06 11:45
 **/
public class OneHundredAndFortyEightSortList {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 1, 4, 2};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = sortList1(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }


    public static ListNode sortList1(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        ListNode mid =slow.next;
        slow.next=null;
        ListNode left=sortList1(head);
        ListNode right=sortList1(mid);
        ListNode res =merge(left,right);
        return res;

    }
    public static ListNode merge(ListNode h1,ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(h1!=null && h2!=null){
            if(h1.value<h2.value){
                cur.next=h1;
                h1=h1.next;
            }else{
                cur.next=h2;
                h2=h2.next;
            }
            cur =cur.next;
        }
        if(h1!=null) cur.next=h1;
        if(h2!=null) cur.next=h2;
        return dummy.next;
    }

    /**
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }

        if (left != null) {
            res.next = left;
        } else {
            res.next = right;
        }
        return dummy.next;
    }

}
