package simple;


/**
 * @description: 453. 最小移动次数使数组元素相等
 * @author: sunhaiting
 * @create: 2020-02-28 18:04
 **/
public class FourHundredAndFiftyThreeMinMovesJava {
    public static void main(String[] args) {
        int arr[] =  new int[]{1,2,3,4,5};
        int i = minMoves(arr);
        System.out.println(i);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int min = 0, max = nums.length - 1, count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            if (nums[max] == nums[min]) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i]++;
                }
            }
            count++;
        }
        return count;
    }
}

