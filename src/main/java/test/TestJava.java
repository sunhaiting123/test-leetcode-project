package test;

import java.util.ArrayList;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-03-30 23:34
 **/
public class TestJava {
    public static void main(String[] args) {
        int sum = 0;//记录总值
        for(int i=1;i<100;i++){
            sum += i/2!=0 ?i:-i;
        }
        System.out.println(sum);


//        for (int i = 0; i < 3; i++) {
//            System.out.println("+++++++" + i);
//        }
//
//
//        for (int i = 0; i < 3; ++i) {
//            System.out.println("=====" + i);
//        }
//
//        int[] nums ={1,2,3,4,5};
//        System.out.println(nums.length);
//        System.out.println(nums);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.size();


        for (int i = (int) Math.pow(2, 3); i < (int) Math.pow(2, 3 + 1); ++i) {
            //十进制数转换成二进制
            String bitmask = Integer.toBinaryString(i).substring(1);
            System.out.println("i:" + i + "====" + bitmask);
        }


//        int[] nums ={6,1,2,7,9,3,4,5,10,8};
//        int[] sort = sort(nums);
//        for(int i :sort){
//            System.out.println(i);
//        }

    }

//    public static int[] sort(int[] nums) {
//        return sortBetween(nums, 0, nums.length-1);
//    }


//    public static int[] sortBetween(int[] nums, int low, int high) {

//        if (nums.length == 0 || low < 0 || high >= nums.length || low > high) return null;
//
//        int i = low;
//        int j = high;
//        int base = nums[low];
//
//        while (i < j) {
//            while (base <= nums[j] && i < j) {
//                j--;
//            }
//            while (base >= nums[i] && i < j) {
//                i++;
//            }
//
//
//
//            if (i < j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
//        //这时是i==j,交换基准点和j索引的值
//        nums[low] = nums[j];
//        nums[j] = base;
//
//        sortBetween(nums, low, j - 1);
//        sortBetween(nums, j + 1, high);
//        return nums;
//    }
}
