package hard.array;

/**
 * @description: 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * @author: sunhaiting
 * @create: 2022-08-12 15:48
 **/
public class TwoHundredAndEightySevenFindDuplicate {
    public static void main(String[] args) {

        int[] nums ={1,3,4,2,2};
        System.out.println(findDuplicate2(nums));
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }


    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int fast = 0;
        int slow = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
