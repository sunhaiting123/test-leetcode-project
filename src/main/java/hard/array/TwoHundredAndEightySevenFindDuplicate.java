package hard.array;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-08-12 15:48
 **/
public class TwoHundredAndEightySevenFindDuplicate {
    public static void main(String[] args) {

    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
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
}
