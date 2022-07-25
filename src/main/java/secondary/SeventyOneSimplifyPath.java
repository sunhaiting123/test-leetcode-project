package secondary;

import java.util.Stack;

/**
 * @description: 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * @author: sunhaiting
 * @create: 2020-04-03 10:07
 **/
public class SeventyOneSimplifyPath {
    public static void main(String[] args) {

        String str = "/a//b////c/d//././/..";
        String s = simplifyPath(str);
        System.out.println(s);

    }

    /**
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     *
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] s = path.split("/");

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals("..")) {
                stack.pop();
            } else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) {
                stack.push(s[i]);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            buffer.append("/" + stack.get(i));
        }
        return buffer.toString();
    }
}
