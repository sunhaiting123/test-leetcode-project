package secondary.array;

/**
 * @description: 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @author: sunhaiting
 * @create: 2020-03-31 23:01
 **/
public class SixtyThreeUniquePathsWithObstacles {
    public static void main(String[] args) {

        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        int i = uniquePathsWithObstacles(arr);
        System.out.println(i);
    }

    /**
     * 输入:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * 输出: 2
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1) return 0;

        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (dp[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 1; j < n; j++) {
            if (dp[0][j] == 0 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
