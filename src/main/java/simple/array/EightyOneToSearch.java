package simple.array;

/**
 * @description: 81. 搜索旋转排序数组 II
 * 题目：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * @author: sunhaiting
 * @create: 2020-04-26 21:11
 **/
public class EightyOneToSearch {
    public static void main(String[] args) {

        int[] nums ={2,5,6,0,0,1,2};
        boolean search = search(nums, 8);
        System.out.println(search);
    }


    public  static  boolean  search(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            //10111 ,11101分不清前后哪个有序，所以去掉重复项
            if(nums[left]==nums[mid]){
                left = left +1;
                continue;
            }

            if(nums[left]>nums[mid]){
                if(target>nums[mid] && target<=nums[left]){
                    left = mid+1;
                }else{
                    right =mid-1;
                }
            }else{
                if(target<nums[mid] && target>=nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

        }
        return false;
    }
}
