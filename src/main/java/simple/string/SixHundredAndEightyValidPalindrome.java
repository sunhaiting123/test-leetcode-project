package simple.string;

/**
 * @description: 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @author: sunhaiting
 * @create: 2021-06-18 15:51
 **/
public class SixHundredAndEightyValidPalindrome {
    public static void main(String[] args) {
        String s = "abddb";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }


    /**
     * 双指针计算方法
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }


    public static boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
