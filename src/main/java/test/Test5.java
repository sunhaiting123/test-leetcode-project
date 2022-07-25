package test;

import common.ListNode;
import scala.collection.immutable.List;
import sun.misc.UCDecoder;

import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-05-28 14:34
 **/
public class Test5 {
    public static void main(String[] args) {

    }

    public static int numComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.value) && (cur.next == null || !set.contains(cur.next.value))) {
                res++;
            }
            cur = cur.next;
        }
        return res;
    }


    public static ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int m = count / k;
        int n = count % k;

        ListNode[] arr = new ListNode[k];
        ListNode pre = head;
        for (int i = 0; i < k; i++) {

            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            for (int j = 0; j < m + (n < i ? 1 : 0); j++) {
                current.next = new ListNode(pre.value);
                current = current.next;
                pre = pre.next;

            }
            arr[i] = dummy.next;

        }

        return arr;
    }


    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 == null) pre.next = l2;
        if (l2 == null) pre.next = l1;
        return dummy.next;
    }


    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int length = lists.length;
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = merge(lists[i], lists[length - 1 - i]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];

    }


    public static int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        ListNode pre = cur.next;
        ArrayList<Integer> list = new ArrayList<>();

        while (cur != null && cur.next != null) {
            while (pre != null) {
                if (cur.value < pre.value) {
                    list.add(pre.value);
                    break;
                } else {
                    pre = pre.next;
                }
            }
            if (pre == null) list.add(0);

            pre = pre.next;
            cur = cur.next;

        }
        list.add(0);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] nextLargerNodes2(ListNode head) {
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (cur != null) {
            list.add(cur.value);
            cur = cur.next;
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;

    }


    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static int getDecimalValue3(ListNode head) {
        ListNode cur = head;
        int sum = 0;
        while (cur != null) {
            sum = sum * 2 + cur.value;
            cur = cur.next;
        }
        return sum;
    }

    public static int getDecimalValue2(ListNode head) {
        ListNode cur = head;
        int sum = 0;
        while (cur != null) {
            sum <<= 1;
            sum += cur.value;
            cur = cur.next;
        }
        return sum;
    }


    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int a = 0;
        while (h1 != null || h2 != null) {
            int m = h1 == null ? 0 : h1.value;
            int n = h2 == null ? 0 : h2.value;
            int sum = m + n + a;
            int i = 10;
            a = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;

        }
        if (a > 0) {
            cur.next = new ListNode(a);
        }
        return dummy.next;
    }


    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
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


    public static ListNode addTwoNumbers2(ListNode h1, ListNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (h1 != null) {
            s1.push(h1.value);
            h1 = h1.next;
        }

        while (h2 != null) {
            s2.push(h2.value);
            h2 = h2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int a = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || a != 0) {
            int m = s1.isEmpty() ? 0 : s1.pop();
            int n = s2.isEmpty() ? 0 : s2.pop();
            int sum = (m + n + a) / 10;
            a = (m + n + a) % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        ListNode dummy = new ListNode(-1);
        ListNode a = dummy;
        while (left != null && right != null) {
            if (left.value < right.value) {
                a.next = left;
                left = left.next;

            } else {
                a.next = right;
                right = right.next;
            }
            a = a.next;
        }
        if (left != null) {
            a.next = left;
        } else {
            a.next = right;
        }

        return dummy.next;

    }
}
