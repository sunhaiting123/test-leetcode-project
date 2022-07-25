package simple;

import java.util.HashMap;
import java.util.Stack;


/**
 * @description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 栈：先进后出
 * @author: sunhaiting
 * @create: 2019-11-07 18:22
 **/
public class TwentyIsValidJava {

    public static void main(String[] args) {
        HashMap<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        String s = "{[}]";
        boolean flag = isValid(s);
        System.out.println(flag);
    }

    public static boolean isValid(String s) {

        // Initialize hash map with mappings. This simply makes the code easier to read.
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}


