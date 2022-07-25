package simple;

import java.util.Arrays;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-02-29 10:29
 **/
public class FourHundredAndSeventyFiveFindRadiusJava {
    public static void main(String[] args) {
        int[] houses= new int[]{1,2,4};
        int[] heaters= new int[]{3,6};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);


    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int len1 = houses.length;
        int len2 = heaters.length;
        int result = 0;
        for (int i = 0; i < len1; i++) {
            //遍历房屋,找到每一个房屋距离供暖器的最短距离
            int min = 0;
            //最左边
            if (houses[i] < heaters[0]) {
                min = heaters[0] - houses[i];
            }
            //最右边
            else if (houses[i] > heaters[len2 - 1]) {
                min = houses[i] - heaters[len2 - 1];
            } else {
                //相当于查找目标元素在供暖器数组中的插入位置
                int left = 0;
                int right = len2 - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (heaters[mid] < houses[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (heaters[left] == houses[i]) {
                    min = 0;
                } else {
                    min = Math.min(houses[i] - heaters[left - 1], heaters[left] - houses[i]);
                }
            }
            result = Math.max(min, result);
        }
        return result;
    }
}


