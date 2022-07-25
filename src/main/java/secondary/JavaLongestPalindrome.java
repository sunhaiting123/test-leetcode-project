package secondary;


/**
 * @description:
 * @author: sunhaiting
 * @create: 2019-11-06 18:38
 **/


public class JavaLongestPalindrome {
    public static void main(String[] args) {
        String s = "abcbadd";
        String a = longestPalindrome(s);

        System.out.println(a);


        int[][] arr = new int[2][2];
        System.out.println(arr[0][0] + "===" + arr.length);


//        ArrayList<Integer> objects = new ArrayList<Integer>();
//
//        objects.add(0,1);
//        System.out.println(objects.get());



    }


    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 暴力解法
     * 时间复杂度：O(n3)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }


    /**
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


}

