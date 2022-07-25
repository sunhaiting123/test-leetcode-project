package common;

import java.util.ArrayList;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-01-08 10:09
 **/
public class ListNode {
    public ListNode next;
    public int value = 0;

    public ListNode() {
    }

    public ListNode(Integer value) {
        this.value = value;
    }

    public ListNode(ListNode next, int value) {
        this.next = next;
        this.value = value;
    }

    //数组转换成链表
    public static ListNode arrayToListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        ListNode root = new ListNode(arr[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < arr.length; i++) {//由于已给root赋值，所以i从1开始
            other.next = new ListNode(arr[i]);//将other的下一个节点指向生成的新的节点
            other = other.next;//将other指向最后一个节点(other的下一个节点)
        }
        return root;
    }

    public static ArrayList<Integer> listNodeToArray(ListNode node) {
        if (node == null) {
            throw new IllegalArgumentException("node can not be empty");
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }

        return list;

    }


}


