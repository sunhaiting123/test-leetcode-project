package secondary.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-07-11 19:02
 **/
public class ThirtyNinetTrap {
    public static void main(String[] args) {

//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = trap2(height);
        System.out.println(trap);
    }


    /**
     * 动态规划
     * min(max_left[i]，max_right[i])-height[i]
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int result = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        max_left[0] = height[0];
        max_right[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }

        for (int j = len - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j + 1], height[j]);
        }

        for (int k = 0; k < len; k++) {
            result += Math.min(max_left[k], max_right[k]) - height[k];
        }

        return result;
    }

    /**
     * 单调栈
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                Integer left = stack.peek();
                int curWide = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                res += curWide * curHeight;
            }
            stack.push(i);
        }
        return res;
    }


    /**
     * 双指针可以这么理解： 一开始两个指针在两端，假设h[left] < h[right] ，则有left ++ 直到 h[left] > h[right]。
     * 那么此时，h[left]是遍历过程中第一个大于h[right]的，显然是遍历过程中的最大值。
     * 然后right ++ 直到 h[right] > h[left] ，同样的，此时h[right]为遍历过程中的最大值。
     *
     * 即：left移动时，h[right] = rightMax。 right移动时，h[left] = leftMax
     * h[left] < h[right] 的情况只会出现在：right 刚刚找到自己的最大值，left在寻找更大值的过程中。
     * 所以此时必然有leftMax < rightMax
     */
    /**
     * 双指针
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;

    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }



}
