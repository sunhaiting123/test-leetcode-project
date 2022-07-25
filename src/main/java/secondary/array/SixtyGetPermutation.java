package secondary.array;

import java.util.ArrayList;

/**
 * @description: 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * @author: sunhaiting
 * @create: 2020-03-30 17:14
 **/
public class SixtyGetPermutation {
    public static void main(String[] args) {
        String permutation = getPermutation(3, 4);
        System.out.println(permutation);


    }

    /**
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {

        int[] fact = new int[n];

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            //fact存入0！，1！，2！...,(n-1)!
            fact[i] = fact[i - 1] * i;
            //nums 存入1，2，3，...，n
            nums.add(i + 1);
        }
        k = k - 1;
        StringBuffer str = new StringBuffer();
        for (int j = n - 1; j >= 0; j--) {
            int x = k / fact[j];
            k = k % fact[j];
            str.append(nums.get(x));
            nums.remove(x);
        }
        return str.toString();
    }
}
