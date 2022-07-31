package secondary.array;

/**
 * @description: *  122.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * *         设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * @author: sunhaiting
 * @create: 2022-07-30 11:48
 **/
public class OnehundredAndTwentyTwoMaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit2(prices);
        System.out.println(i);
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += Math.max(0, prices[i] - prices[i - 1]);
        }
        return max;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }


}
