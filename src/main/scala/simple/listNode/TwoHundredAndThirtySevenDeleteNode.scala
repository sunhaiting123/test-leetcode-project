package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 237. 删除链表中的节点
  * @author: sunhaiting
  * @create: 2020-01-07 17:55
  **/
object TwoHundredAndThirtySevenDeleteNode {
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
    val arr = Array(1, 2, 3, 4, 5)
    val list = new ListNodeScala()
    val node = list.setListNode(arr)
    deleteNode(list2)
    println(list1.next.x)
    deleteNode(node.next)
    println(node.next.x)
  }

  /**
    * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    * 示例 1:
    * 输入: head = [4,5,1,9], node = 5
    * 输出: [4,1,9]
    * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
    *
    * @param node
    */
  def deleteNode(node: ListNodeScala): Unit = {
    node.x = node.next.x
    node.next = node.next.next
  }
}
