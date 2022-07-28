package hard.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-07-27 10:25
 **/
public class EightyFourLargestRectangleArea {
    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] nums = {3, 1, 3, 2, 2};
        int i = largestRectangleArea3(nums);
        System.out.println(i);
    }


    /**
     * 暴力解法
     * 左边看一下，看最多能向左延伸多长，找到大于等于当前柱形高度的最左边元素的下标；
     * 右边看一下，看最多能向右延伸多长；找到大于等于当前柱形高度的最右边元素的下标。
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int curHeight = heights[i];
            while (left > 1 && heights[left - 1] >= curHeight) {
                left--;
            }
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int wide = right - left + 1;
            res = Math.max(res, wide * curHeight);

        }
        return res;
    }


    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }


    /**
     * 单调栈+哨兵
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] nums = new int[len + 2];
        nums[0] = 0;
        nums[len + 1] = 0;
        for (int i = 1; i <= len; i++) {
            nums[i] = heights[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);
        int res = 0;
        for (int i = 1; i < len + 2; i++) {
            while (nums[i] < nums[stack.peekLast()]) {
                int curHeight = nums[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}

