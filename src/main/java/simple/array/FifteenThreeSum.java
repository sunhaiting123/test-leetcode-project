package simple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 15. 三数之和
 * 题目：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @author: sunhaiting
 * @create: 2020-04-27 09:43
 **/
public class FifteenThreeSum {
    public static void main(String[] args) {

        int[] nums = {-1, 1, 1, 0, 0};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);

            }
            System.out.println("=====");
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            //因为进行左边重复值判断，避免i越界，加上i>0判断，同时跳出本次循环保证去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<Integer> list = new ArrayList<>();
            int j = i + 1;
            int k = nums.length - 1;
            int sum = nums[i] + nums[j] + nums[k];
            while (j < k) {
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);

                    //通过左边 和右边去重，获取下一个可能出现的滑动窗口
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
