package simple.listnode;

import common.ListNode;
import common.ListNodeScala;

import java.util.HashSet;

/**
 * @description: 141. 环形链表
 * 判断链表是否有环
 * @author: sunhaiting
 * @create: 2020-04-17 09:42
 **/
public class OneHundredAndFortyOneHasCycle {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
//        list5.next = list3;
        boolean bool = hasCycle2(list1);
        System.out.println(bool);

    }

    /**
     * hash方法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 双指针法
     * 环形跑道扣圈
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
