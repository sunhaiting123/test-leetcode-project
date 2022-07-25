package simple.array;

import java.util.Arrays;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-27 09:30
 **/
public class SixteenThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);


    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }

                if (sum > target) {
                    k = k - 1;
                } else if (sum < target) {
                    j = j + 1;
                } else {
                    break;
                }
            }
        }
        return ans;

    }
}
