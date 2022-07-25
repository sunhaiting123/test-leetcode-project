package hard.string;


import java.util.HashMap;

/**
 * @description: 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @author: sunhaiting
 * @create: 2022-07-22 10:57
 **/
public class SeventySixMinWindow {
    public static void main(String[] args) {

        String s = "ABEDCODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);


    }


    /**
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> ht = new HashMap<>();
        HashMap<Character, Integer> hs = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(s.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = Integer.MAX_VALUE, cnt = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;

            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }


}

