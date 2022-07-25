package simple.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-27 11:20
 **/
public class ThreeHundredAndFortyNineToIntersection {
    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = intersection2(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }

    /**
     * 双指针，写入set用来去重
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] new_num = new int[set.size()];
        int x = 0;
        for (int y : set) {
            new_num[x] = y;
            x++;
        }
        return new_num;

    }


    /**
     * 使用二分法，判断一个数组中的元素是否在另一个数组中，如果在，添加到set中
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {

        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                set.add(num);
            }
        }

        int[] new_nums = new int[set.size()];
        int i = 0;
        for (int s : set) {
            new_nums[i] = s;
            i++;
        }
        return new_nums;
    }

    private static boolean binarySearch(int num, int[] nums2) {
        int left = 0;
        int right = nums2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num == nums2[mid]) {
                return true;
            } else if (num > nums2[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }
}
