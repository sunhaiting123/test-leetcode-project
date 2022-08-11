package secondary.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description:239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * @author: sunhaiting
 * @create: 2022-08-11 17:51
 **/
public class TwoHundredAndThrityNineMaxSlidingWindow {
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 双向队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];

        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                queue.pollLast();
            }
            queue.addLast(right);
            int left = right - k + 1;

            while (queue.peekFirst() < left) {
                queue.pollFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
