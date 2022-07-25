package sort;

/**
 * @description: 排序算法
 * @author: sunhaiting
 * @create: 2020-04-30 21:30
 **/
public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {6, 2, 4, 3, 7, 9, 8, 10, 1, 5};
        int[] ints = quickSort(nums, 0, nums.length - 1);
//        int[] ints = bubbleSort(nums);
//        int[] ints = selectionSort(nums);
//        int[] ints = insertionSort(nums);
        for (int i : ints) {
            System.out.println(i);
        }
//        Object
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param low
     * @param high
     */
    public static int[] quickSort(int[] nums, int low, int high) {
        if (nums.length == 0 || low < 0 || high >= nums.length || low > high) return null;
        //左边哨兵的索引
        int i = low;
        //右边哨兵的索引
        int j = high;
        //基准点(以最左边的值为基准点) 基准点的左边的值小于基准点，右边的值大于基准点
        int base = nums[low];
        while (i < j) {
            //先看右边，如果值大于基准点，依次往左递减
            while (base <= nums[j] && i < j) {
                j--;
            }
            //左边，如果值小于基准点，依次往右递减
            while (base >= nums[i] && i < j) {
                i++;
            }

            //当满足i索引的值比基准点大，j索引的值比基准点小，交换两个位置的值
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        //这时是i==j,交换基准点和j索引的值
        nums[low] = nums[j];
        nums[j] = base;

        //i=j
        //这时  左半数组<(i或j所在索引的数)<右半数组
        //也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
        // 只要用相同的方法 分别处理  左右数组就可以了
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);

        return nums;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
//    public static int[] mergeSort(int[] nums) {
//        return sort(nums, 0, nums.length - 1);
//    }

//    private static int[] sort(int[] nums, int i, int i1) {
//
//        if (nums.length < 2) return nums;
//
//
//
//    }


    /**
     * 冒泡排序
     * <p>
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param nums
     * @return
     */

    public static int[] bubbleSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     * 最佳情况：T(n) = O(n2)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }


    /**
     * 插入排序
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param nums
     * @return
     */
    public static int[] insertionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int cur;
        for (int i = 0; i < nums.length - 1; i++) {
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
