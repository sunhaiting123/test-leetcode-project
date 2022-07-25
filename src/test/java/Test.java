import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-05-15 23:04
 **/
public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode listNode = ListNode.arrayToListNode(arr);
        int fun = fun(listNode,2 );
//        System.out.println(fun);

        List<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        List<Integer> arrayList2=arrayList1;
        arrayList2.add(3);
        System.out.println("===="+arrayList2.size());
        for(int i: arrayList2){
            System.out.println(i);
        }

    }




    public  static  int fun(ListNode head,int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        for(int i=0;i<=k;i++){
            p = p.next;
        }
        while (p!=null){
            p= p.next;
            q= q.next;
        }
         q = q.next;
        return  q.value;
    }
}
