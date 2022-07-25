package secondary.listNode

import common.ListNodeScala

/**
  *
  * @description: 24. 两两交换链表中的节点
  * @author: sunhaiting
  * @create: 2020-03-10 23:14
  **/
object TwentyFourswapPairs {
  def main(args: Array[String]): Unit = {
    val list1 = new ListNodeScala(1)
    val list2 = new ListNodeScala(2)
    val list3 = new ListNodeScala(3)
    val list4 = new ListNodeScala(4)
    list1.next = list2
    list2.next = list3
    list3.next = list4
    val node = swapPairs(list1)
    println(node.x, node.next.x, node.next.next.x, node.next.next.next.x)
  }

  /**
    *
    * @param head
    * @return
    */
  def swapPairs(head: ListNodeScala): ListNodeScala = {

    val dummy = new ListNodeScala(0)
    dummy.next = head
    var prevNode = dummy

    while (prevNode.next != null && prevNode.next.next != null) {
      val firstTmp = prevNode.next
      val secondTmp = prevNode.next.next
      //交换
      prevNode.next = secondTmp
      firstTmp.next = secondTmp.next
      secondTmp.next = firstTmp
      //jump
      prevNode = firstTmp

    }
    dummy.next
  }
}
