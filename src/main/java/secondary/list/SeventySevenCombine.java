package secondary.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author: sunhaiting
 * @create: 2020-04-08 13:38
 **/
public class SeventySevenCombine {
    public static void main(String[] args) {

        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    /**
     * 迭代
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(0);
        }
        int i = 0;
        while (i >= 0) {
            //当前数字加 1
            temp.set(i, temp.get(i) + 1);
            //当前数字大于 n，对应回溯法的 i == n + 1，然后回到上一层
            if (temp.get(i) > n) {
                i--;
                // 当前数字个数够了
            } else if (i == k - 1) {
                ans.add(new ArrayList<>(temp));
                //进入更新下一个数字
            } else {
                i++;
                //把下一个数字置为上一个数字，类似于回溯法中的 start
                temp.set(i, temp.get(i - 1));
            }
        }
        return ans;
    }

    /**
     * 回溯
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(1, new ArrayList<Integer>(), k, n, output);
        return output;
    }

    public static void backtrack(int first, List<Integer> curr, int k, int n, List<List<Integer>> output) {
        //如果 curr 里的数字够了 k 个，就把它加入到结果中
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }
        //从 first 到 n
        for (int i = first; i < n + 1; i++) {
            //将当前数字加入 temp
            curr.add(i);
            //进入递归
            backtrack(i + 1, curr, k, n, output);
            //将当前数字删除，进入下次 for 循环
            curr.remove(curr.size() - 1);
        }
    }
}
