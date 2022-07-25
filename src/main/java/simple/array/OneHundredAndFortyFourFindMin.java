package simple.array;

/**
 * @description: 154.寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * @author: sunhaiting
 * @create: 2020-04-26 18:32
 **/
public class OneHundredAndFortyFourFindMin {
    public static void main(String[] args) {

        int[] nums ={3,3,4,5,6,7,0,1,2,3,3,3,3,3};
        int min = findMin(nums);
        System.out.println(min);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid ;
            } else {
                //去掉重复元素
                right = right - 1;
            }
        }

        return nums[left];
    }


}
