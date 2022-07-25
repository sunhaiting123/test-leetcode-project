package simple.array;

import java.util.Arrays;

/**
 * @description: Leetcode350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author: sunhaiting
 * @create: 2020-04-27 11:11
 **/
public class ThreeHundredAndFiftyToIntersect {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 3, 4};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }

    }

    /**
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
