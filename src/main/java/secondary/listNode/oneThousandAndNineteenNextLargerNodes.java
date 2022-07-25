package secondary.listNode;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。
 * 如果不存在这样的 j，那么下一个更大值为 0 。
 * <p>
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * @author: sunhaiting
 * @create: 2020-06-17 11:08
 **/
public class oneThousandAndNineteenNextLargerNodes {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 3, 5};
        ListNode listNode = ListNode.arrayToListNode(arr);
        int[] ints = nextLargerNodes2(listNode);
        for (int i : ints) {
            System.out.println(i);
        }

    }

    /**
     * 输入：[2,1,5]
     * 输出：[5,5,0]
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        ListNode pre = cur.next;
        ArrayList<Integer> list = new ArrayList<>();

        while (cur != null && cur.next != null) {
            while (pre != null) {
                if (cur.value > pre.value) {
                    pre = pre.next;
                } else {
                    list.add(pre.value);
                    break;
                }
            }
            if (pre == null) {
                list.add(0);
            }
            cur = cur.next;
            pre = cur.next;
        }
        list.add(0);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }


    /**
     * 单调栈解法
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes2(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.value);
            head = head.next;
        }

        int[] res = new int[list.size()];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.peek()] = list.get(i);
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
