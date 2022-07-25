package secondary.array;

/**
 * @description: 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author: sunhaiting
 * @create: 2020-04-07 22:04
 **/
public class SeventyFiveSortColors {
    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        int curr = 0;
        int temp = 0;
        while (curr <= j) {
            if (nums[curr] == 0) {
                temp = nums[curr];
                nums[curr++] = nums[i];
                nums[i++] = temp;
            } else if (nums[curr] == 2) {
                temp = nums[curr];
                nums[curr] = nums[j];
                nums[j--] = temp;

            } else {
                curr++;
            }
        }
    }
}
