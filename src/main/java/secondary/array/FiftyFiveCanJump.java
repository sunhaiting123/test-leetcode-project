package secondary.array;


/**
 * @description: 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @author: sunhaiting
 * @create: 2020-03-28 13:35
 **/
public class FiftyFiveCanJump {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        int nums2[] = {3, 2, 1, 1, 0};
        boolean b = canJump2(nums2);
        System.out.println(b);
    }

    /**
     * 递归
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    public static boolean canJumpFromPosition(int position, int[] nums) {

        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= furthestJump; i++) {
            if (canJumpFromPosition(i, nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 自右向左
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        Index[] memo = new Index[nums.length];

        for (int i = 0; i < memo.length - 1; i++) {
            memo[i] = Index.UNKOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= min; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    enum Index {
        GOOD, BAD, UNKOWN
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public static boolean canJump3(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;

    }
}
