package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 160. 相交链表
  *               编写一个程序，找到两个单链表相交的起始节点。
  * @author: sunhaiting
  * @create: 2020-01-02 17:27
  **/
object OnehundredAndSixtyIntersectionNode {
  def main(args: Array[String]): Unit = {
    val node1 = new ListNodeScala(4)
    val list1 = new ListNodeScala(1)
    val list2 = new ListNodeScala(8)
    val list3 = new ListNodeScala(4)
    val list4 = new ListNodeScala(5)
    node1.next = list1
    list1.next = list2
    list2.next = list3
    list3.next = list4

    val node2 = new ListNodeScala(5)
    val list5 = new ListNodeScala(0)
    val list6 = new ListNodeScala(1)

    node2.next = list5
    list5.next = list1
    list1.next = list2
    list2.next = list3
    list3.next = list4

//    val arr1 = Array(4,1,8,4,5)
//    val list11 = new ListNodeScala()
//    val node1 = list11.sss(arr1)
//
//    val arr2 = Array(5,0,1,8,4,5)
//    val list22 = new ListNodeScala()
//    val node2 = list22.sss(arr2)

    val node = getIntersectionNode(node1, node2)
    println(node.x)

  }

  /**
    * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    * 输出：Reference of the node with value = 8
    * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
    * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
    * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
    *
    * @param headA
    * @param headB
    * @return
    */
  def getIntersectionNode(headA: ListNodeScala, headB: ListNodeScala): ListNodeScala = {
    var ha = headA
    var hb = headB
    while (ha != hb) {
      if (ha != null) ha = ha.next else ha = headB
      if (hb != null) hb = hb.next else hb = headA
    }
    ha
  }

}
