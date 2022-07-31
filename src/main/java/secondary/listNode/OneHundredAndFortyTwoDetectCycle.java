package secondary.listNode;

import common.ListNode;

/**
 * @description: 142. 环形链表
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * @author: sunhaiting
 * @create: 2020-06-05 22:47
 **/
public class OneHundredAndFortyTwoDetectCycle {
    public static void main(String[] args) {
//        ListNode list1 = new ListNode(1);
//        ListNode list2 = new ListNode(2);
//        ListNode list3 = new ListNode(3);
//        ListNode list4 = new ListNode(4);
//        ListNode list5 = new ListNode(5);
//        list1.next = list2;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
//        list5.next = list3;

        ListNode list1 = new ListNode(3);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(0);
        ListNode list4 = new ListNode(-4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list1;
        ListNode listNode = detectCycle2(list1);
        System.out.println(listNode.value);

    }
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow =head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast =fast.next.next;
            slow=slow.next;

            if(slow==fast){
                ListNode pre =head;
                while(pre!=slow){
                    pre =pre.next;
                    slow =slow.next;
                }
                return pre;
            }
        }
        return null;
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
