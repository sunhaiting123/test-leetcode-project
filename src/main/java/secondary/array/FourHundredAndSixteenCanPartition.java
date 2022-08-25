package secondary.array;

/**
 * @description: 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @author: sunhaiting
 * @create: 2022-08-24 11:21
 **/
public class FourHundredAndSixteenCanPartition {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0;
        int maxValue = 0;
        for (int num : nums) {
            sum += num;
            maxValue = Math.max(maxValue, num);
        }
        //总和是奇数
        if (sum % 2 != 0) {
            return false;
        }
        //最大值超过总和的一半
        int target = sum / 2;
        if (maxValue > target) {
            return false;
        }
        // dp[i][j] : 从[0,i]中选取nums中的若干个正整数使得和为j
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            //从[0,i]中不选任何正整数
            dp[i][0] = true;
        }
        //i=0时，只有一个正数nums[0]可以被选取
        dp[0][nums[0]] = true;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
