package simple;

import java.util.PrimitiveIterator;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2019-11-11 18:11
 **/
public class SixtySixPlusOneJava {


    public static void main(String[] args) {
      int arr[] =  new int[]{4,3,2,1,5};
        int[] ints = plusOne(arr);
        System.out.println(ints.length);


    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
