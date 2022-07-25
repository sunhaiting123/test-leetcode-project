package secondary.matrix;

/**
 * @description: 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @author: sunhaiting
 * @create: 2020-04-07 17:44
 **/
public class SeventyFourSearchMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean b = searchMatrix2(matrix, 23);
        System.out.println(b);


    }

    /**
     * 1.先判断目标值在第几行
     * 2.再找到对应的位置
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        for (int i = 0; i < row; i++) {
            if (target < matrix[i][0]) {
                x = i - 1;
                break;
            } else if (target == matrix[i][0]) {
                return true;
            }

        }

        int left = 0;
        int right = col - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > matrix[x][mid]) {
                left = mid + 1;
            } else if (target < matrix[x][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;
        int mid, m, n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            m = mid / col;
            n = mid % col;
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
