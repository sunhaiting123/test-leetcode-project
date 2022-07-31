package secondary.array;

import java.util.HashSet;

/**
 * @description:128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * @author: sunhaiting
 * @create: 2022-07-31 10:13
 **/
public class OnehundredAndTwentyEightLongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 5, 6, 7};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }


    /**
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int setNum : set) {
            if (!set.contains(setNum - 1)) {
                int curNum = setNum;
                int curLong = 1;

                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLong += 1;
                }
                res = Math.max(res, curLong);
            }
        }
        return res;
    }


}
