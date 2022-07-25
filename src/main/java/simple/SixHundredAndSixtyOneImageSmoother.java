package simple;

/**
 * @description: 661. 图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * @author: sunhaiting
 * @create: 2021-05-19 11:03
 **/
public class SixHundredAndSixtyOneImageSmoother {
    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] ints = imageSmoother(img);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }

    /**
     * @param img
     * @return
     */
    public static int[][] imageSmoother(int[][] img) {
        int r = img.length, c = img[0].length;
        int[][] ans = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        if (m >= 0 && n >= 0 && m < r && n < c) {
                            ans[i][j] += img[m][n];
                            count++;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }
}
