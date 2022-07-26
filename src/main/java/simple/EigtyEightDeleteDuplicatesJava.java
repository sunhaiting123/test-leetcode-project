package simple;


/**
 * @description: 88:给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author: sunhaiting
 * @create: 2019-11-13 11:25
 **/
public class EigtyEightDeleteDuplicatesJava {

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("C"));

    }
}


/**
 * 定义链表
 */
class SingleLinkedList {
    private int size;//链表节点的个数
    private ListNode head;//头节点

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }


    public SingleLinkedList() {
        size = 0;
        head = null;
    }


    //链表的每个节点类
    private class ListNode {
        private Object data;//每个节点的数据
        private ListNode next;//每个节点指向下一个节点的连接

        public ListNode(Object data) {
            this.data = data;
        }
    }


    //在链表头添加元素
    public Object addHead(Object obj) {
        ListNode newHead = new ListNode(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public ListNode find(Object obj) {
        ListNode current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回true
    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        ListNode current = head;
        ListNode previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的节点是第一个节点
        if (current == head) {
            head = current.next;
            size--;
        } else {//删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            ListNode node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }
}
