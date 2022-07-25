package secondary.listNode;

import common.ListNode;

import java.util.HashSet;

/**
 * @description: 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * @author: sunhaiting
 * @create: 2020-06-17 16:46
 **/
public class EightHundredAndSeventeenNumComponents {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4};
        ListNode node = ListNode.arrayToListNode(arr);
        int[] G = {0, 3, 1, 4};
        int i = numComponents(node, G);
        System.out.println(i);
    }

    /**
     * head: 0->1->2->3->4
     * G = [0, 3, 1, 4]
     * 输出: 2
     * 解释:
     * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
     *
     * @param head
     * @param G
     * @return
     */
    public static int numComponents(ListNode head, int[] G) {
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
}
