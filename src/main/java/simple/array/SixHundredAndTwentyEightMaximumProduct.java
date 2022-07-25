package simple.array;

/**
 * @description: 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @author: sunhaiting
 * @create: 2021-05-13 14:36
 **/
public class SixHundredAndTwentyEightMaximumProduct {
    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,-1,-2};
        int i = maximumProduct(nums);
        System.out.println(i);

    }

    public static int maximumProduct(int[] nums) {
//        最小的，第二小的值
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        最大的，第二大，第三大的值
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
