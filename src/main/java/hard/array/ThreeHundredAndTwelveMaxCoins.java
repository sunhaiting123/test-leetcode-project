package hard.array;

import scala.Array;

import java.util.Arrays;

/**
 * @description: 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * @author: sunhaiting
 * @create: 2022-08-16 16:12
 **/
public class ThreeHundredAndTwelveMaxCoins {
    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};
        int i = maxCoins2(nums);
        System.out.println(i);


    }

    /**
     * 动态规划： dp[i][j] 表示填满开区间(i,j)能得到的最多硬币数，i<j−1
     * @param nums
     * @return
     */
    public static int maxCoins2(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            points[i + 1] = nums[i];
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], points[i] * points[k] * points[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }


    public static int[][] rec;
    public static int[] val;

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public static int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

}
