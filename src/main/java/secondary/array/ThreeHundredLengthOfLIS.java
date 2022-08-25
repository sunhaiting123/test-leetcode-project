package secondary.array;

/**
 * @description: 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @author: sunhaiting
 * @create: 2022-08-15 17:37
 **/
public class ThreeHundredLengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));
    }


    /**
     * 动态规划
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 贪心+二分法
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int len = 1;
        int n = nums.length;
        if (n == 0) return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (nums[i] > d[mid]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
