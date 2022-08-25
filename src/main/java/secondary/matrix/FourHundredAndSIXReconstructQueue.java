package secondary.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * @author: sunhaiting
 * @create: 2022-08-24 10:02
 **/
public class FourHundredAndSIXReconstructQueue {
    public static void main(String[] args) {

        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue2(people);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }

    }

    /**
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {

        //按照第一个升序排列，第二个降序排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                } else {
                    return p2[1] - p1[1];
                }
            }
        });

        int n = people.length;
        int[][] res = new int[n][];
        for (int[] p : people) {
            int pre = p[1] + 1;
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    pre--;
                    if (pre == 0) {
                        res[i] = p;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int[][] reconstructQueue2(int[][] people) {

        //按照第一个降序排列，第二个升序排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

