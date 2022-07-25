package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 206. 反转链表
  *               输入: 1->2->3->4->5->NULL
  *               输出: 5->4->3->2->1->NULL
  * @author: sunhaiting
  * @create: 2020-01-06 15:56
  **/
object TwohundredAndSixReverseList {
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
    val node = reverseList(list1)
    println(node.x, node.next.x, node.next.next.x, node.next.next.next.x, node.next.next.next.next.x)

  }

  /**
    *
    * @param head
    * @return
    */
  def reverseList(head: ListNodeScala): ListNodeScala = {
    var pre: ListNodeScala = null
    var cur = head
    while (cur != null) {
      //记录当前节点的下一个节点
      val tmp = cur.next
      //将当前节点指向pre
      cur.next = pre
      //pre和cur节点都前进一位
      pre = cur
      cur = tmp
    }
    pre
  }


}
