package secondary.array;

import java.util.Arrays;

/**
 * @description: 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @author: sunhaiting
 * @create: 2020-03-30 11:39
 **/
public class FiftyNineGenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }

    }

    /**
     * 输入: 3
     * 输出:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = temp++;
            }
            for (int j = i + 1; j < n - i; j++) {
                res[j][n - i - 1] = temp++;
            }

            for (int j = n - 1 - i - 1; j >= i; j--) {
                res[n - i - 1][j] = temp++;
            }
            for (int j = n - 1 - i - 1; j > i; j--) {
                res[j][i] = temp++;
            }
        }
        return res;
    }
}
