package simple.array;

import java.util.Arrays;

/**
 * @description: 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @author: sunhaiting
 * @create: 2022-08-17 16:39
 **/
public class ThreeHundredAndThirtyEightCountBits {
    public static void main(String[] args) {
        int[] ints = countBits(5);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    /**
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        int highbit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highbit = i;
            }
            dp[i] = dp[i - highbit] + 1;
        }
        return dp;
    }

    /**
     * @param n
     * @return
     */
    public static int[] countBits3(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
