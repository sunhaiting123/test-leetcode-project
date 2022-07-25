package secondary.listNode

import common.ListNodeScala

/**
  *
  * @description:  19. 删除链表的倒数第N个节点
  * @author: sunhaiting
  * @create: 2020-03-09 15:49
  **/
object SeventeenrRemoveNthFromEnd {
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

    val node2 = removeNthFromEnd(list1, 2)
    println(node2.x,node2.next.x,node2.next.next.x,node2.next.next.next.x)

  }

  /**
    * 双指针
    *
    * @param head
    * @param n
    * @return
    */
  def removeNthFromEnd(head: ListNodeScala, n: Int): ListNodeScala = {
    val dummy = new ListNodeScala(0)
    dummy.next = head
    var p = dummy
    var q = dummy

    for (i <- 0 to n) {
      p = p.next
    }
    while (p != null) {
      p = p.next
      q = q.next
    }

    q.next = q.next.next
    dummy.next
  }
}
