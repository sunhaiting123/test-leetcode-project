package secondary.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 49. 字母异位词分组
 * *               给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @author: sunhaiting
 * @create: 2020-04-26 09:43
 **/
public class FortyNineToGroupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for(int i = 0 ; i<lists.size();i++){
            List<String> strings = lists.get(i);
            for(String s: strings){
                System.out.println(s);
            }
            System.out.println("===========");
        }

    }


    /**
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                int i = c - 'a';
                count[i]++;
            }
            StringBuffer stringBuffer = new StringBuffer();

            for (int i : count) {
                stringBuffer.append(i);
            }
            String key = stringBuffer.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }

}
