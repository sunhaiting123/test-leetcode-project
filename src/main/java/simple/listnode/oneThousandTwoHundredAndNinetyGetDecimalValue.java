package simple.listnode;

import common.ListNode;

/**
 * @description: 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * @author: sunhaiting
 * @create: 2020-06-17 09:47
 **/
public class oneThousandTwoHundredAndNinetyGetDecimalValue {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        ListNode listNode = ListNode.arrayToListNode(arr);
        int decimalValue = getDecimalValue3(listNode);
        System.out.println(decimalValue);

    }


    /**
     * 位运算
     *
     * @param head
     * @return
     */
    public static int getDecimalValue2(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans <<= 1;
            ans += cur.value;
            cur = cur.next;
        }
        return ans;
    }


    /**
     * 直接使用二进制转十进制方法
     * @param head
     * @return
     */
    public static int getDecimalValue3(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans = ans * 2 + cur.value;
            cur = cur.next;
        }
        return ans;
    }

    /**
     * 翻转链表的方式
     *
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        ListNode node = reverse(head);
        int i = 0;
        int res = 0;
        while (node != null) {
            int value = node.value;
            int pow = (int) Math.pow(2, i);
            res = res + value * pow;
            node = node.next;
            i++;
        }
        return res;
    }


    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;

        }
        return pre;
    }


}
