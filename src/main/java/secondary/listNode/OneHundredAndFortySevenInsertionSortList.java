package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 147. 对链表进行插入排序
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * @author: sunhaiting
 * @create: 2020-06-06 10:05
 **/
public class OneHundredAndFortySevenInsertionSortList {
    public static void main(String[] args) {


        int[] arr = {5, 6, 3, 1, 4, 2};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = insertionSortList(listNode);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode1);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    /**
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {

        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 如果是升序，则遍历下一个
            if (end.value < cur.value) {
                end = cur;
                cur = cur.next;
            } else {
                // 先定义一个 tmp 指向 cur 下一个结点防止丢链
                ListNode tmp = cur.next;
                // 断开要排的元素
                end.next = tmp;
                // 从头判断找出合适的插入位置
                while (pre.next != null && pre.next.value < cur.value) {
                    pre = pre.next;
                }
                // 找到插入位置后直接将元素放进来
                cur.next = pre.next;
                pre.next = cur;
                // 随后将定位指针归为
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }


}

