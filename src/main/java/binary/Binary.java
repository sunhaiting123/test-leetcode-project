package binary;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-06-30 14:06
 **/
public class Binary {
    //旋转数组查找最小值，无重复元素
    //leetcode 33
    public static int fun1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];

    }


    //旋转数组查找最小值，有重复元素
    //leetcode 81
    public static int fun2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[right];
    }


    // 旋转数组查找目标值，存在返回目标值的索引,不存在-1,无重复元素
    //leetcode 153
    public static int fun3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半段有序
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;

                }

            }

            //后半段有序
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //leetcode 154
    // 旋转数组查找目标值，存在true,不存在false,有重复元素
    public static boolean fun4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            //前半段有序
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;

                }

            }

            //后半段有序
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 1, 1, 2, 3, 3, 3, 3};
        boolean min = fun4(nums, 6);
        System.out.println(min);

    }
}
