package common

/**
  *
  * @description: ${description}
  * @author: sunhaiting
  * @create: 2019-11-14 10:34
  **/
class ListNodeScala(var _x: Int = 0) {
  var next: ListNodeScala = null //指向的下一个节点
  var x: Int = _x //节点的数据


  def setListNode(arr: Array[Int]):ListNodeScala = {
    if (arr == null || arr.length == 0)
      throw new IllegalArgumentException("arr can not be empty")
    this.x = arr(0)
    var curNode = this
    for (i <- 1 until arr.length) {
      curNode.next = new ListNodeScala(arr(i))
      curNode = curNode.next
    }
    curNode
  }


  //  public ListNode (int[] arr){
  //
  //    if(arr == null || arr.length == 0)
  //      throw new IllegalArgumentException("arr can not be empty");
  //
  //    this.val = arr[0];
  //    ListNode curNode = this;
  //    for(int i = 1 ; i < arr.length ; i ++){
  //      curNode.next = new ListNode(arr[i]);
  //      curNode = curNode.next;
  //    }
}

