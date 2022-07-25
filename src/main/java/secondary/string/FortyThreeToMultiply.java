package secondary.string;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-26 10:52
 **/
public class FortyThreeToMultiply {
    public static void main(String[] args) {
        String multiply = multiply("123", "456");
        System.out.println(multiply);

    }

    /**
     * @param s1
     * @param s2
     * @return
     */
    public static String multiply(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] arr = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int n1 = s1.charAt(i) - '0';
                int n2 = s2.charAt(j) - '0';
                int s = n1 * n2 + arr[i + j + 1];
                arr[i + j + 1] = s % 10;
                arr[i + j] = s / 10 + arr[i + j];
            }
        }

        StringBuffer s = new StringBuffer();
        for (int i =0;i<arr.length;i++) {
            //去掉首位为0的情况
            if (i == 0 && arr[0]==0) {
                continue;
            }
            s.append(arr[i]);
        }
        return s.toString();
    }



}
