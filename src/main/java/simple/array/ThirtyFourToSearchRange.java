package simple.array;

/**
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: sunhaiting
 * @create: 2020-04-26 18:14
 **/
public class ThirtyFourToSearchRange {
    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8,8,8, 10};
        int[] ints = searchRange(arr, 8);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     *
     * @param arr
     * @return
     */
    public static int[] searchRange(int[] arr, int target) {
        //查找左边界

        int[] res = {-1,-1};

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;

            } else if (arr[mid] > target) {
                right = mid-1;
            } else {
                if (mid == 0 || arr[mid - 1] < target) {
                    res[0] = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }

        }

        //查找右边界
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    res[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }

            }

        }
        return res;
    }
}
