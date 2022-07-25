package simple;

import common.MinStack;

/**
 * @description: 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @author: sunhaiting
 * @create: 2020-01-02 16:18
 **/
public class OnehundredAndFiftyFiveMinStackJava {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        int min = minStack.getMin();
        System.out.println(min);
    }

}
