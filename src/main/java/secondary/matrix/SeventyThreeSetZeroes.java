package secondary.matrix;

/**
 * @description: 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * @author: sunhaiting
 * @create: 2020-04-03 10:40
 **/
public class SeventyThreeSetZeroes {
    public static void main(String[] args) {

//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        setZeroes2(matrix);
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }


        }
    }


    /**
     * 先找到标记为0的值，记这些值为一个标记值，再最后赋值为0
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {

        int x = -100000;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix[i][j];
                if (a == 0) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = x;
                    }
                    for (int h = 0; h < n; h++) {
                        matrix[i][h] = x;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == x) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 方案二
     *
     * @param matrix
     */

    public static void setZeroes2(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        //单独处理第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }

        //单独处理第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }

        //处理除第一行和第一列其他的数据
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //如果第一列标记的值为0，则将当前行数据置为0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroOneRow(matrix, i);
            }
        }

        //如果第一行标记的值为0，则将当前列数据置为0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroOneCol(matrix, j);
            }
        }
        //第一行
        if (firstRow) {
            zeroOneRow(matrix, 0);
        }
        //第一列
        if (firstCol) {
            zeroOneCol(matrix, 0);
        }


    }


    /**
     * 将一列数据置为0
     *
     * @param matrix
     * @param m
     */
    public static void zeroOneCol(int[][] matrix, int m) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][m] = 0;
        }

    }

    /**
     * 将一行数据置为0
     *
     * @param matrix
     * @param n
     */
    public static void zeroOneRow(int[][] matrix, int n) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[n][j] = 0;
        }

    }
}