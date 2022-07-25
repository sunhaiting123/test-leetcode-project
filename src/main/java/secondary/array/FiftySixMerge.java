package secondary.array;


import java.util.*;

/**
 * @description: 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * @author: sunhaiting
 * @create: 2020-03-30 09:46
 **/
public class FiftySixMerge {
    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(arr);
        for (int[] a : merge) {
            System.out.println(Arrays.toString(a));
        }

    }

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
//
//        // 根据二维数组第一个数字大小按每一行整体排序
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]) {
                list.add(intervals[i]);
                //前一个的结束 大于等于 后一个的开始,则合并
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        int[][] arr = new int[list.size()][2];
        int index = 0;
        while (!list.isEmpty()) {
            arr[index] = list.removeFirst();
            index++;
        }
        return arr;
    }
}
