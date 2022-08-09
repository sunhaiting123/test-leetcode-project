package secondary.array;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-08-09 11:36
 **/
public class TwoHundredAndFifteenFindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 7, 8, 9,11,12,13};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);

    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        return quickSelect(nums, 0, len - 1, len - k);

    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if (nums.length == 0 || low < 0 || high > nums.length - 1 || low > high) return 0;
        int i = low;
        int j = high;
        int base = nums[i];
        while (i < j) {
            while (base <= nums[j]) {
                j--;
            }
            while (base >= nums[i]) {
                i++;
            }

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[low] = nums[j];
        nums[j] = base;

        if (j > k) {
            return quickSelect(nums, low, j - 1, k);
        } else if (j < k) {
            return quickSelect(nums, j + 1, high, k);
        } else {
            return base;
        }
    }
}
