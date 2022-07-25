package simple.listnode;

import common.ListNode;

/**
 * @description: Leetcode234. 回文链表
 * @author: sunhaiting
 * @create: 2020-04-20 09:26
 **/
public class TwoHundredAndThirtyFourIsPalindrome {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(2);
        ListNode list5 = new ListNode(1);
        list1.next = list2;
        list2.next = list3;
        list3.next = list3;
        list3.next = list4;
        list4.next = list5;
        boolean bool = isPalindrome(list1);
        System.out.println(bool);
    }


    /**
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @param head
     * @return
     */
    public static Boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        //快慢指针，当快指针到最后，慢指针刚好指向中间位置。
        if (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //快指针置于后半部分链表
        fast = slow.next;
        //断开前后两部分链表
        slow.next = null;
        //慢指针置于前半部分链表
        slow = dummy.next;

        ListNode pre = null;
        //翻转快链表
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = temp;

        }
        //回文校验x
        // 前后半链表逐一比较，当链表长度为奇数时前半段链表长度比后半段多1，所以以后半段为准
        //将链表前半部分和反转的后半部分对比
        while (pre != null && slow != null) {
            if (pre.value != slow.value) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
