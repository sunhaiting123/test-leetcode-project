package secondary.string;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-05-21 10:05
 **/
public class FortyThreeMultiply {
    public static void main(String[] args) {

    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1 == "0" || num2 == "0") return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] arr = new int[l1 + l2];

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int m = num1.charAt(i) - '0';
                int n = num2.charAt(j) - '0';
                int sum = m * n + arr[i + j + 1];
                arr[i + j + 1] = sum % 10;
                arr[i + j] = sum / 10 + arr[i + j];
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0) {
                continue;
            }
            buffer.append(arr[i]);
        }
        return buffer.toString();

    }
}
