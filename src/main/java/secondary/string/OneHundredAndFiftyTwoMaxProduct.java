package secondary.string;

/**
 * @description:152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @author: sunhaiting
 * @create: 2022-07-31 13:09
 **/
public class OneHundredAndFiftyTwoMaxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(i);

    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int max = maxF[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(maxF[i], max);
        }
        return max;
    }

    /**
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
