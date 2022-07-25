package hard.listnode;

import common.ListNode;

import java.util.ArrayList;

/**
 * @description: 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @author: sunhaiting
 * @create: 2020-04-22 18:31
 **/
public class TwentyThreeMergeKLists {
    public static void main(String[] args) {

        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
        ListNode node1 = ListNode.arrayToListNode(arr1);
        ListNode node2 = ListNode.arrayToListNode(arr2);
        ListNode node3 = ListNode.arrayToListNode(arr3);
        ListNode[] arr = {node1, node2, node3};
        ListNode listNode = mergeKLists2(arr);
        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
        for (int i : arrayList) {
            System.out.println(i);
        }

    }

    /**
     * 输入:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);


    }

    /**
     * 归并的方式
     * 通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
     * 通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
     *
     * @param lists
     * @param begin
     * @param end
     * @return
     */
    public static ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) return lists[begin];
        int mid = begin + (end - begin) / 2;

        ListNode left = helper(lists, begin, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwoLists(left, right);


    }

    /**
     * 迭代
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return dummy.next;
    }



    /**
     * 合并数组中第k个链表到第1个链表，合并数组中第k-1个链表到第2个链表，依次这样操作...
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {

        if(lists==null || lists.length==0){
            return  null;
        }

        int len = lists.length;
        while (len>1){
            for(int i=0;i<len/2;i++){
                lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }
}
