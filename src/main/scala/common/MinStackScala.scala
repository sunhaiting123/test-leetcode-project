package common

import java.util

/**
  *
  * @description: 155. 最小栈
  *               设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
  *               push(x) -- 将元素 x 推入栈中。
  *               pop() -- 删除栈顶的元素。
  *               top() -- 获取栈顶元素。
  *               getMin() -- 检索栈中的最小元素。
  * @author: sunhaiting
  * @create: 2020-01-02 15:44
  **/
class MinStackScala {
  // 数据栈
  private var data: util.Stack[Int] = _
  // 辅助栈
  private var helper: util.Stack[Int] = _

  /**
    * initialize your data structure here.
    */
  def MinStack() {
    data = new util.Stack[Int]()
    helper = new util.Stack[Int]()
  }

  // 思路 1：数据栈和辅助栈在任何时候都同步

  def push(x: Int): Boolean = {
    // 数据栈和辅助栈一定会增加元素
    data.add(x)
    if (helper.isEmpty() || helper.peek() >= x) {
      helper.add(x)
    } else {
      helper.add(helper.peek())
    }
  }

  def pop(): Unit = {
    // 两个栈都得 pop
    if (!data.isEmpty()) {
      helper.pop()
      data.pop()
    }
  }

  def top(): Int = {
    if (!data.isEmpty()) {
      data.peek()
    }
    throw new RuntimeException("栈中元素为空，此操作非法")
  }

  def getMin(): Int = {
    if (!helper.isEmpty()) {
      helper.peek()
    }
    throw new RuntimeException("栈中元素为空，此操作非法")
  }

}
