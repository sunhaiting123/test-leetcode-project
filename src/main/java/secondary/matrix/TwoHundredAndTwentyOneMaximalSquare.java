package secondary.matrix;

/**
 * @description:221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @author: sunhaiting
 * @create: 2022-08-09 14:58
 **/
public class TwoHundredAndTwentyOneMaximalSquare {
    public static void main(String[] args) {
        char[][] martix = {
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}};

        int i = maximalSquare(martix);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {

        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSize;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }
}
