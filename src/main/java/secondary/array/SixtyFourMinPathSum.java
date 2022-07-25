package secondary.array;


/**
 * @description: 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @author: sunhaiting
 * @create: 2020-04-02 11:27
 **/
public class SixtyFourMinPathSum {
    public static void main(String[] args) {

        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int i = minPathSum(arr);
        System.out.println(i);
    }

    /**
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }


}
