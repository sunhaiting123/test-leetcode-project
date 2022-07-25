package secondary.array;

import java.util.*;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-07-11 09:48
 **/
public class ThirtyNineCombinationSumJava {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(nums, 7);
        System.out.println(Arrays.toString(lists.toArray()));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        //排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> list = new LinkedList<>();
        dfs(candidates, 0, len, target, res, list);
        return res;
    }

    public static void dfs(int[] candidates, int begin, int len, int target, List<List<Integer>> res, Deque<Integer> list) {

        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        //从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序
            if (target - candidates[i] < 0) {
                break;
            }
            list.addLast(candidates[i]);
            //由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], res, list);
            list.removeLast();
        }
    }
}
