package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 203. 移除链表元素
  *               删除链表中等于给定值 val 的所有节点。
  * @author: sunhaiting
  * @create: 2020-01-05 11:08
  **/
object TwohundredAndThreeRemoveElements {
  def main(args: Array[String]): Unit = {
    val list1 = new ListNodeScala(1)
    val list2 = new ListNodeScala(2)
    val list3 = new ListNodeScala(3)
    val list4 = new ListNodeScala(4)
    val list5 = new ListNodeScala(5)
    list1.next = list2
    list2.next = list3
    list3.next = list3
    list3.next = list4
    list4.next = list5
    val value = 2
    val node = removeElements2(list1, value)
    println(node)
    println(node.x)
    println(node.next.x)
    println(node.next.next.x)
    println(node.next.next.next.x)
  }

  /**
    * 示例:
    *
    * 输入: 1->2->6->3->4->5->6, val = 6
    * 输出: 1->2->3->4->5
    *
    * @param head
    * @param value
    * @return
    */
  def removeElements(head: ListNodeScala, value: Int): ListNodeScala = {
    //添加虚拟头节点
    var head1 = head
    val newHead = new ListNodeScala(0)
    newHead.next = head1
    head1 = newHead

    var currentNode = head1.next
    var previousNode = head1
    while (currentNode != null) {
      if (currentNode.x == value) {
        previousNode.next = currentNode.next
        currentNode.next = null
        currentNode = previousNode.next
      }
      else {
        currentNode = currentNode.next
        previousNode = previousNode.next
      }
    }
    newHead.next
  }

  def removeElements2(head: ListNodeScala, value: Int): ListNodeScala = {
    //添加虚拟头节点，防止删除的元素是第一个
    val newHead = new ListNodeScala()
    newHead.next = head

    var cur = newHead.next
    var pre = newHead

    println(pre)
    println(newHead)

    println(cur)
    println(head)
    while (cur != null) {
      if (cur.x == value) {
        pre.next = cur.next
      } else {
        pre = pre.next
      }
      cur = cur.next
    }
    newHead.next
  }
}
