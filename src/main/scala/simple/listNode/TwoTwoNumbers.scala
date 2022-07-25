package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 2. 两数相加
  *               给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
  *               并且它们的每个节点只能存储 一位 数字。
  *               如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  *               您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  * @author: sunhaiting
  * @create: 2020-03-03 10:42
  **/
object TwoTwoNumbers {
  def main(args: Array[String]): Unit = {

    val arr1 = Array(1, 2, 3)
    val arr2 = Array(4, 5, 6)
    val list1 = new ListNodeScala()
    list1.setListNode(arr1)
    val list2 = new ListNodeScala()
    list2.setListNode(arr2)
    val node = addTwoNumbers(list1,list2)
    println(node.x,node.next.x,node.next.next.x)

  }

  /**
    *
    * @param l1
    * @param l2
    * @return
    */
  def addTwoNumbers(l1: ListNodeScala, l2: ListNodeScala): ListNodeScala = {
    //不知道首节点是什么，可以随便设置一个，返回值去他的下一个值即可
    val dummy = new ListNodeScala(0)
    //设置一个指针指向dummy,留住首个值，这样指针可以继续进行
    var cur = dummy
    var p = l1
    var q = l2
    var carry = 0
    while (p != null || q != null) {
      val x = if (p != null) p.x else 0
      val y = if (q != null) q.x else 0
      val sum = x + y + carry
      carry = sum / 10
      cur.next = new ListNodeScala(sum % 10)
      cur = cur.next
      if (p != null) p = p.next
      if (q != null) q = q.next
    }
    if (carry > 0) {
      cur.next = new ListNodeScala(carry)
    }
    dummy.next
  }
}
