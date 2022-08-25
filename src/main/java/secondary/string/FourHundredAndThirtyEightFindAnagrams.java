package secondary.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @author: sunhaiting
 * @create: 2022-08-25 10:57
 **/
public class FourHundredAndThirtyEightFindAnagrams {
    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        int pLen = p.length();
        int sLen = s.length();

        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        int diff = 0;
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            diff += count[i];
        }

        if (diff == 0) {
            list.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            int m = s.charAt(i) - 'a';
            if (count[m] == 0) diff++;
            if (count[m] == 1) diff--;
            count[m]--;
            int n = s.charAt(i + pLen) - 'a';
            if (count[n] == -1) diff--;
            if (count[n] == 0) diff++;
            count[n]++;

            if (diff == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
