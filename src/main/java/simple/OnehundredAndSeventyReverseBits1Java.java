package simple;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2019-11-25 18:04
 **/
public class OnehundredAndSeventyReverseBits1Java {
    public static void main(String[] args) {
        int n=43261596;
        int i = reverseBits1(n);
        System.out.println(i);

    }

    /**
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     *
     * @param n
     * @return
     */
    public static int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }


}
