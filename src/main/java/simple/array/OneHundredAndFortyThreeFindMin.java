package simple.array;

/**
 * @description:Leetcode 153. 寻找旋转排序数组中的最小值
 * 题目：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * @author: sunhaiting
 * @create: 2020-04-26 21:05
 **/
public class OneHundredAndFortyThreeFindMin {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,1,2,3};
        int min = findMin(nums);
        System.out.println(min);
    }

    public  static  int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left +(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return  nums[left];
    }
}
