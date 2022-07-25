package hard.array;

/**
 * @description: 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * @author: sunhaiting
 * @create: 2022-07-07 12:20
 **/
public class TenIsMatch {


    public static void main(String[] args) {

        String s = "abc";
        String p = "abcc*";
        boolean match = isMatch(s, p);
        System.out.println(match);

    }

    public static boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0]=true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                } else {
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];
                    } else {
                        f[i][j] = f[i][j - 2];
                    }
                }
            }
        }
        return f[m][n];
    }


    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
