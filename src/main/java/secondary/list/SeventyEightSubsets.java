package secondary.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @author: sunhaiting
 * @create: 2020-04-08 14:53
 **/
public class SeventyEightSubsets {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);


        for (int i = (int) Math.pow(2, 3); i < (int) Math.pow(2, 3 + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            //十进制数转换成二进制
            String bitmask = Integer.toBinaryString(i).substring(1);
            System.out.println("i:" + i + "====" + bitmask);

        }
    }

    /**
     * 迭代运算
     * 开始假设输出子集为空，每一步都向子集添加新的整数，并生成新的子集。
     * (),(1),(2),(1,2),(3),(1,3),(2,3),(1,2,3)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(num);
                newSubsets.add(list);
            }
            output.addAll(newSubsets);
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
        }
        return output;
    }

    /**
     * 二进制运算
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String substring = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (substring.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            output.add(list);
        }

        return output;
    }
}
