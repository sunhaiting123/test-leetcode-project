package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 725. 分隔链表
 * <p>
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * @author: sunhaiting
 * @create: 2020-06-17 15:58
 **/
public class SevenHundredAndTwentyFiveSplitListToParts {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode[] listNodes = splitListToParts(listNode, 5);

        for (ListNode node : listNodes) {
            ArrayList<Integer> arrayList = ListNode.listNodeToArray(node);
            for (int i : arrayList) {
                System.out.println(i);
            }
            System.out.println("=========");
        }


    }

    /**
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode cur = root;
        while (cur != null) {
            count++;
            cur = cur.next;
        }


        int m = count / k;
        int n = count % k;

        ListNode[] arr = new ListNode[k];
        ListNode pre = root;
//        for (int i = 0; i < n; i++) {
//            ListNode dummy = new ListNode(-1);
//            ListNode current = dummy;
//            for (int j = 0; j < m + 1; j++) {
//                current.next = new ListNode(pre.value);
//                current = current.next;
//                pre = pre.next;
//            }
//            arr[i] = dummy.next;
//        }
//        for (int i = n; i < k; i++) {
//            ListNode dummy = new ListNode(-1);
//            ListNode current = dummy;
//            for (int j = 0; j < m; j++) {
//                current.next = new ListNode(pre.value);
//                current = current.next;
//                pre = pre.next;
//            }
//            arr[i] = dummy.next;
//        }


        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            for (int j = 0; j < m + (i < n ? 1 : 0); j++) {
                current.next = new ListNode(pre.value);
                current = current.next;
                pre = pre.next;
            }
            arr[i] = dummy.next;
        }

        return arr;
    }
}
