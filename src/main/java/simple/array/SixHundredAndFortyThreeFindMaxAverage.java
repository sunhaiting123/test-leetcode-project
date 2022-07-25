package simple.array;

/**
 * @description: 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @author: sunhaiting
 * @create: 2021-05-13 16:44
 **/
public class SixHundredAndFortyThreeFindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double maxAverage = findMaxAverage(nums, 4);
        System.out.println(maxAverage);
    }

    /**
     * 滑动窗口方式，加一个，减一个
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int j = k; j < length; j++) {
            sum = sum - nums[j - k] + nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }
}
