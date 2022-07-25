package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 141. 环形链表
  *               给定一个链表，判断链表中是否有环。
  *               为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
  * @author: sunhaiting
  * @create: 2020-01-02 14:01
  **/
object OnehundredAndFortyOneHasCycle {
  def main(args: Array[String]): Unit = {
    val list1 = new ListNodeScala(1)
    val list2 = new ListNodeScala(2)
    val list3 = new ListNodeScala(3)
    val list4 = new ListNodeScala(4)
    val list5 = new ListNodeScala(5)
    list1.next = list2
    list2.next = list3
    list3.next = list4
    list4.next = list5
    list5.next = list3
    val arr = Array(1,2,3,4,5,3)
    val list = new ListNodeScala()
    val value = list.setListNode(arr)
    val bool = hasCycle2(list1)
    println(bool)
    val bool2 = hasCycle2(value)
    println(bool2)
  }

  /**
    * 输入：head = [3,2,0,-4], pos = 1
    * 输出：true
    * 解释：链表中有一个环，其尾部连接到第二个节点。
    * 哈希表
    *
    * @param head
    * @return
    */
  def hasCycle(head: ListNodeScala): Boolean = {
    var head1 = head
    val nodesSeen = new java.util.HashSet[ListNodeScala]()
    var result = false
    var flag = true
    while (head1 != null && flag) {
      if (nodesSeen.contains(head1)) {
        flag = false
        result = true
      } else {
        nodesSeen.add(head1)
      }
      head1 = head1.next
    }
    result
  }

  /**
    * 双指针
    *
    * @param head
    * @return
    */
  def hasCycle2(head: ListNodeScala): Boolean = {
    var result = true
    var flag = true
    if (head == null || head.next == null) {
      result = false
      flag = false
    }
    var slow = head
    var fast = head.next
    while (slow != fast && flag) {
      if (fast == null || fast.next == null) {
        result = false
        flag = false
      } else {
        slow = slow.next
        fast = fast.next.next
      }
    }
    result
  }


}
