package test;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-06-06 11:25
 **/
public class TestSort {
    public static void main(String[] args) {

    }


    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int cur;
        for (int i = 0; i < nums.length-1; i++) {
            cur = nums[i + 1];
            int pre = i;
            while (pre >= 0 && nums[pre] > cur) {
                nums[pre + 1] = nums[pre];
                pre--;
            }
            nums[pre + 1] = cur;
        }
        return nums;
    }
}

