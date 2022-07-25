package hard.array;

/**
 * @description: 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @author: sunhaiting
 * @create: 2020-04-20 22:14
 **/
public class FourFindMedianSortedArrays {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     * 递归
     *
     * @param nums1
     * @param nums2
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 1) / 2;

        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right) * 0.5);

    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.max(nums1[start1], nums2[start2]);

        int i = start1 + Math.max(len1 - 1, k / 2) - 1;
        int j = start2 + Math.max(len2 - 1, k / 2) - 1;

        if (nums1[i] > nums2[j]) {

            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }


    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        //左边最大值
        int mid1 = 0;
        //右边最小值
        int mid2 = 0;
        int left = 0;
        int right = m;
        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            //考虑边界问题
            int n1_left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int n1_right = i == m ? Integer.MAX_VALUE : nums1[i];
            int n2_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int n2_right = j == n ? Integer.MAX_VALUE : nums2[j];
            //存在一个最大的 i 满足A[i−1]≤B[j],这时候的A[i]>B[j−1]
            if (n1_left <= n2_right) {
                mid1 = Math.max(n1_left, n2_left);
                mid2 = Math.min(n1_right, n2_right);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }
}
