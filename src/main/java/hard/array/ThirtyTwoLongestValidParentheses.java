package hard.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-07-10 17:17
 **/
public class ThirtyTwoLongestValidParentheses {
    public static void main(String[] args) {

        String s = ")(())(";
        int i = longestValidParentheses1(s);
        System.out.println(i);

    }

    /**
     * 动态规划：dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2]
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            //i - dp[i - 1] - 1是与当前')'对应的位置
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 使用额外空间栈
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

}
