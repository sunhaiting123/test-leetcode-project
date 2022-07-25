package simple;


/**
 * @description:
 * @author: sunhaiting
 * @create: 2019-11-12 16:45
 **/
public class SeventyClimbStairsJava {

    public static void main(String[] args) {
        int i = climb_Stairs(0, 5);
        int i1 = climb_Stairs2(5);
        System.out.println(i);
        System.out.println(i1);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    /**
     * 菲波那切数列
     * 第 i 阶可以由以下两种方法得到：
     * 在第 (i−1)阶后向上爬一阶。
     * 在第 (i−2) 阶后向上爬 2 阶。
     * 所以到达第 i 阶的方法总数就是到第 (i−1) 阶和第 (i−2)阶的方法数之和。
     * 令 dp[i] 表示能到达第 i 阶的方法总数：
     * dp[i]=dp[i−1]+dp[i−2]
     *
     * @param n
     * @return
     */
    public  static  int climb_Stairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}


