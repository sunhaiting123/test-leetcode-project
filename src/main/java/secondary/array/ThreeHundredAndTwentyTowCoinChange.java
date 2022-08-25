package secondary.array;

import java.util.Arrays;

/**
 * @description: 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * @author: sunhaiting
 * @create: 2022-08-17 14:30
 **/
public class ThreeHundredAndTwentyTowCoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 5};
        int i = coinChange(coins, 19);
        System.out.println(i);
    }

    /**
     * 动态规划
     * dp初始化值为amount+1，因为amount最多就只能是由amount个1组成
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
