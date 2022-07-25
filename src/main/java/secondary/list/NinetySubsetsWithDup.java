package secondary.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @author: sunhaiting
 * @create: 2020-04-10 22:47
 **/
public class NinetySubsetsWithDup {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2};
        List<List<Integer>> lists = subsetsWithDup4(nums);

        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println("=======");
        }
    }

    /**
     * 二进制方式
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String substring = Integer.toBinaryString(i).substring(1);

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (substring.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }

            if (!output.contains(list)) {
                output.add(list);
            }
        }
        return output;
    }

    /**
     * 迭代
     * 正常计算，如果结果中存在list,就不添加
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newList = new ArrayList<>();

            for (List<Integer> curr : output) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(nums[i]);
                newList.add(list);
            }
            for (List<Integer> list : newList) {
                if (!output.contains(list)) {
                    output.add(list);
                }
            }
        }
        return output;
    }


    /**
     * 迭代
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ans_tmp = new ArrayList<>();
            // 遍历之前的所有结果
            for (int j = 0; j < output.size(); j++) {
                List<Integer> list = output.get(j);
                //如果出现重复数字，就跳过所有旧解
                if (i > 0 && nums[i] == nums[i - 1] && j < start) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]); // 加入新增数字
                ans_tmp.add(tmp);
            }
            start = output.size(); //更新新解的开始位置
            output.addAll(ans_tmp);
        }

        return output;
    }


    /**
     * 二进制方式
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String substring = Integer.toBinaryString(i).substring(1);
            boolean flag = true;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (substring.charAt(j) == '1') {
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    // 比如nums=【1,2,2】, 二进制101和110都表示{1,2}
                    // 按照j的枚举顺序, 101 -> 110,所以判断如果当前位j为1并且的前一位为0，同时nums[j]==nums[j-1]

                    if (j > 0 && nums[j] == nums[j - 1] && substring.charAt(j - 1) == '0') {
                        flag = false;
                        break;
                    } else {
                        list.add(nums[j]);
                    }
                }
            }

            if (flag) {
                output.add(list);
            }
        }
        return output;
    }

}
