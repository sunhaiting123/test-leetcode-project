package test;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-07-29 09:46
 **/
public class LinkedListDemo {
    public static void main(String[] args) {

        // create a LinkedList
        LinkedList list = new LinkedList();

        // add some elements
        list.add("Hello");
        list.add(2);
        list.add("Chocolate");
        list.add("10");

        // print the list
        System.out.println("LinkedList:" + list);

        // retrieve and remove the last element of the list
        System.out.println("Last element of the list:" + list.pollLast());
        System.out.println("Last element of the list:" + list.poll());
        System.out.println("Last element of the list:" + list.pop());

        // print the list
        System.out.println("LinkedList:" + list);


        Stack stack = new Stack();
        stack.push("Hello");
        stack.push(2);
        stack.push("Chocolate");
        stack.push("10");
        // print the list
        System.out.println("stack:" + stack);

        // retrieve and remove the last element of the list
        System.out.println("Last element of the list:" + stack.pop());
        System.out.println("Last element of the list:" + stack.peek());

        // print the list
        System.out.println("LinkedList:" + stack);

    }
}
