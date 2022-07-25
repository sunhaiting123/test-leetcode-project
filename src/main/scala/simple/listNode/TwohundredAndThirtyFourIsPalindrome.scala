package simple.listNode

import common.ListNodeScala

/**
  *
  * @description: 234. 回文链表
  * @author: sunhaiting
  * @create: 2020-01-06 21:10
  **/
object TwohundredAndThirtyFourIsPalindrome {
  def main(args: Array[String]): Unit = {
    val list1 = new ListNodeScala(1)
    val list2 = new ListNodeScala(2)
    val list3 = new ListNodeScala(3)
    val list4 = new ListNodeScala(2)
    val list5 = new ListNodeScala(1)
    list1.next = list2
    list2.next = list3
    list3.next = list3
    list3.next = list4
    list4.next = list5
    val bool = isPalindrome(list1)
    println(bool)
  }

  /**
    * 请判断一个链表是否为回文链表。
    *
    * 示例 1:
    *
    * 输入: 1->2
    * 输出: false
    * 示例 2:
    *
    * 输入: 1->2->2->1
    * 输出: true
    *
    * @param head
    * @return
    */
  def isPalindrome(head: ListNodeScala): Boolean = {
    var result = true
    if (head == null || head.next == null) {
      result
    } else {
      val p = new ListNodeScala(-1)
      var fast = p
      var slow = p
      p.next = head
      //慢指针走一步，快指针走两步，当快指针到达终点，慢指针刚好处于中间位置
      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
      }
      //将快指针置于下半段链表中
      fast = slow.next
      //断开前后两个链表
      slow.next = null
      //慢指针置于上半段链表
      slow = p.next
      //翻转快链表
      //----------------------
      var pre: ListNodeScala = null // 保存指针前一节点的信息，用于反转
      while (fast != null) {
        val nextTmp = fast.next
        fast.next = pre
        pre = fast
        fast = nextTmp
      }

      //回文校验x
      // 前后半链表逐一比较，当链表长度为奇数时前半段链表长度比后半段多1，所以以后半段为准
      //将链表前半部分和反转的后半部分对比
      while (pre != null && slow != null && result) {
        if (slow.x != pre.x) {
          result = false
        }
        pre = pre.next
        slow = slow.next
      }
      result
    }
  }
}
