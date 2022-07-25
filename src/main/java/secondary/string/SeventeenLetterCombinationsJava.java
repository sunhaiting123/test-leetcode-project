package secondary.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-06-30 16:43
 **/
public class SeventeenLetterCombinationsJava {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(Arrays.toString(strings.toArray()));

    }

    public static List<String> result = new ArrayList<>();
    static String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return null;

        iterStr(digits, "", 0);
        return result;

    }

    public static void iterStr(String digits, String s, int index) {

        if (digits.length() == index) {
            result.add(s);
            return;
        }

        char c = digits.charAt(index);
        int num = c - '0';
        String s1 = letter_map[num];
        for (int j = 0; j < s1.length(); j++) {
            iterStr(digits, s + s1.charAt(j), index + 1);
        }

    }
}
