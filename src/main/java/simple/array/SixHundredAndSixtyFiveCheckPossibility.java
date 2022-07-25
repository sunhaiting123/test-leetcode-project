package simple.array;

/**
 * @description: 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * @author: sunhaiting
 * @create: 2021-05-20 11:16
 **/
public class SixHundredAndSixtyFiveCheckPossibility {
    public static void main(String[] args) {
        int[] nums ={3,4,6,5};
        boolean b = checkPossibility(nums);
        System.out.println(b);
    }

    /**
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x < y) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
            if (i > 0 && y < nums[i - 1]) {
                nums[i + 1] = x;
            }
        }
        return true;
    }
}
