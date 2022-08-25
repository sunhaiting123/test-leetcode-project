package secondary.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @description:394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * @author: sunhaiting
 * @create: 2022-08-23 11:22
 **/
public class ThreeHundredAndNinetyFourDecodeString {
    public static void main(String[] args) {
        String s = "11[a2[bc]]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }


    /**
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                //多个数字重复出现，比如23，35
                StringBuffer b1 = new StringBuffer();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    b1.append(s.charAt(i));
                    i++;
                }
                stack.addLast(String.valueOf(b1));
            }
            //isLetter,判断字符是不是字母
            else if (Character.isLetter(c) || c == '[') {
                stack.addLast(String.valueOf(c));
                i++;

            } else {
                ArrayList<String> list = new ArrayList<>();
                while (!stack.peekLast().equals("[")) {
                    list.add(stack.pollLast());
                }
                Collections.reverse(list);
                stack.pollLast();
                int x = Integer.parseInt(stack.pollLast());

                StringBuffer b2 = new StringBuffer();
                for (String str : list) {
                    b2.append(str);
                }
                StringBuffer res = new StringBuffer();
                while (x > 0) {
                    res.append(b2);
                    x--;
                }
                stack.addLast(res.toString());
                i++;
            }
        }
        StringBuffer ret = new StringBuffer();
        for (String str : stack) {
            ret.append(str);
        }
        return ret.toString();
    }
}
