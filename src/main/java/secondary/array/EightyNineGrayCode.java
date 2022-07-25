package secondary.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * @author: sunhaiting
 * @create: 2020-04-10 22:02
 **/
public class EightyNineGrayCode {
    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        for(int i:list){
            System.out.println(i);
        }

    }

    /**
     *
     * @param n
     * @return
     */
    public static  List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size()-1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head = head * 2;
        }
        return list;
    }
}
