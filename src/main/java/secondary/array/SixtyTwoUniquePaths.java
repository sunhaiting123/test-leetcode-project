package secondary.array;

/**
 * @description: 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @author: sunhaiting
 * @create: 2020-03-31 22:19
 **/
public class SixtyTwoUniquePaths {
    public static void main(String[] args) {

        int i = uniquePaths2(7, 3);
        System.out.println(i);
    }

    /**
     * dp[i][j]=dp[i][j-1]+dp[i-1][j]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 只保留当前行信息
     * dp[j] = dp[j] + dp[j - 1]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //等式右边的 dp[j]是上一次计算后的，加上左边的dp[j-1]即为当前结果
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }

}


