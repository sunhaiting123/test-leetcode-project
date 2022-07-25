package test;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-05-27 16:19
 **/
public class Test3 {

    public static void main(String[] args) {

    }


    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length + 1];
    }
}
