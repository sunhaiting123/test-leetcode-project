package hard.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @author: sunhaiting
 * @create: 2022-07-28 09:43
 **/
public class EightyFiveMaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int i = maximalRectangle2(matrix);
        System.out.println(i);

    }

    /**
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }

            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (left[i][j] == 0) {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }


    /**
     * 计算每一层的高度
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] nums = new int[len + 2];
        nums[0] = 0;
        nums[len + 1] = 0;
        for (int i = 1; i <= len; i++) {
            nums[i] = heights[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);
        int res = 0;
        for (int i = 1; i < len + 2; i++) {
            while (nums[i] < nums[stack.peekLast()]) {
                int curHeight = nums[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


}
