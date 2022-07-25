package secondary.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * @author: sunhaiting
 * @create: 2020-06-02 15:01
 **/
public class OneHundredAndTwentyMinimumTotal {
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        int i = minimumTotal3(list);
        System.out.println(i);


    }

    /**
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int dp[][] = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (dp[row - 1][i] < res) {
                res = Math.min(dp[row - 1][i], res);
            }
        }
        return res;
    }

    /**
     * 空间复杂度o(n)
     * 自上而下
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);

        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int pre = 0, cur;
        for (int i = 1; i < row; i++) {
            List<Integer> list = triangle.get(i);

            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = list.get(j) + cur;
                } else if (j == i) {
                    dp[j] = list.get(j) + pre;
                } else {
                    dp[j] = Math.min(pre, cur) + list.get(j);
                }
                pre = cur;
            }

        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }

        return res;
    }

    /**
     * 自下而上
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal3(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

}
