package simple

import common.MinStackScala

/**
  *
  * @description: 155. 最小栈
  *               设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
  *               push(x) -- 将元素 x 推入栈中。
  *               pop() -- 删除栈顶的元素。
  *               top() -- 获取栈顶元素。
  *               getMin() -- 检索栈中的最小元素。
  * @author: sunhaiting
  * @create: 2020-01-02 15:35
  **/
object OnehundredAndFiftyFiveMinStack {
  def main(args: Array[String]): Unit = {
    val minStack = new MinStackScala()
    minStack.push(1)
    minStack.push(2)
    minStack.push(3)
    minStack.push(4)
    val i = minStack.getMin()
    println(i)
  }


}
