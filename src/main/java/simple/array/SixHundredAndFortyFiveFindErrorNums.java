package simple.array;

/**
 * @description: 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * @author: sunhaiting
 * @create: 2021-05-14 11:38
 **/
public class SixHundredAndFortyFiveFindErrorNums {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = singleNumber(nums);
        for (int num : res) {
            System.out.println(num);
        }

    }

    /**
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div =ret & (-ret);
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
//        int div =ret & (-ret);
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }


}
