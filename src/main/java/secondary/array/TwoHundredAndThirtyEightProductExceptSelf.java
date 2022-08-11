package secondary.array;

import java.util.Arrays;

/**
 * @description: 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * @author: sunhaiting
 * @create: 2022-08-11 15:42
 **/
public class TwoHundredAndThirtyEightProductExceptSelf {
    public static void main(String[] args) {

        int[] nums={1,2,3,4};
        int[] ints = productExceptSelf2(nums);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int[] ans = new int[len];

        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;

        int[] ans = new int[len];

        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int j = len - 1; j >= 0; j--) {
            ans[j] = ans[j] * right;
            right = right * nums[j];
        }
        return ans;
    }
}
