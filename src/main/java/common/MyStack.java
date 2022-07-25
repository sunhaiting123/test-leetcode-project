package common;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-01-06 20:15
 **/
public class MyStack {

    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        inQueue = new LinkedBlockingQueue<>();
        outQueue = new LinkedBlockingQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.add(x);
        while (!outQueue.isEmpty()) {
            inQueue.add(outQueue.poll());
        }
        while (!inQueue.isEmpty()) {
            outQueue.add(inQueue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return outQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return outQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return outQueue.isEmpty();
    }

}
//单队列实现

class StackByOneQueue2 {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public StackByOneQueue2() {
        queue = new LinkedBlockingQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int count = queue.size();

        queue.add(x);
        while (count > 0) {
            queue.add(queue.poll());
            count--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}


