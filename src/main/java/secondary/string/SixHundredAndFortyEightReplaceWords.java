package secondary.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 648. 单词替换
 * @author: sunhaiting
 * @create: 2020-05-19 20:31
 **/
public class SixHundredAndFortyEightReplaceWords {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String s = "the cattle was rattled by the battery";

        String s1 = replaceWords(list, s);
        System.out.println(s1);
    }

    /**
     * 输入：dict(词典) = ["cat", "bat", "rat"]
     * sentence(句子) = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     *
     * @param dict
     * @param sentence
     * @return
     */
    public static String replaceWords(List<String> dict, String sentence) {

        StringBuffer ans = new StringBuffer();
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String pre = "";
            for (int j = 1; j <= s[i].length(); j++) {
                pre = s[i].substring(0, j);
                if (dict.contains(pre)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(pre);
        }
        return ans.toString();
    }
}
