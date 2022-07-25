package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 83. 删除排序链表中的重复元素
  * @author: sunhaiting
  * @create: 2019-11-13 10:54
  **/
object EigtyThreeDeleteDuplicates {
  def main(args: Array[String]): Unit = {
    val headNode = new ListNodeScala(1)
    val secondNode = new ListNodeScala(2)
    headNode.next = secondNode

    val thirdNode = new ListNodeScala(3)
    secondNode.next = thirdNode

    val fourthNode = new ListNodeScala(4)
    thirdNode.next = fourthNode

    val fifthNode = new ListNodeScala(5)
    fourthNode.next = fifthNode
    val sixNode = new ListNodeScala(5)
    fifthNode.next = sixNode

    var currentNode = headNode
    while (currentNode != null) {
      println(currentNode.x)
      currentNode = currentNode.next
    }

    val node = deleteDuplicates(headNode)
    var currentNode2 = node
    while (currentNode2 != null) {
      println(currentNode2.x)
      currentNode2 = currentNode2.next
    }
  }

  /**
    * 输入: 1->1->2->3->3
    * 输出: 1->2->3
    *
    * @param head
    * @return
    */
  def deleteDuplicates(head: ListNodeScala): ListNodeScala = {
    var current = head
    while (current != null && current.next != null) {
      if (current.next.x == current.x) {
        current.next = current.next.next
      } else {
        current = current.next
      }

    }
    head
  }
}
