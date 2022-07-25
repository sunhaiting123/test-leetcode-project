package secondary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author: sunhaiting
 * @create: 2022-07-12 11:00
 **/
public class FortySixPermutejava {
    public static void main(String[] args) {

        int[] nums ={1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(Arrays.toString(permute.toArray()));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, nums.length, 0, used, path, list);
        return list;

    }


    public static void dfs(int[] nums, int length, int depth, boolean[] used, ArrayList<Integer> path, List<List<Integer>> list) {

        if (depth == length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, used, path, list);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
