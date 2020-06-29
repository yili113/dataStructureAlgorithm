package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-29 10:05
 */
public class SelectSort {
    public static int[] sort(int[] nums) {
        // 第一轮
        int n = nums.length;
        int temp = 0;
//        int min = nums[0];
//        int minIndex = 0;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] < min) {
//                min = nums[i];
//                minIndex = i;
//            }
//        }
//        if (minIndex != 0) {
//            temp = nums[0];
//            nums[0] = nums[minIndex];
//            nums[minIndex] = temp;
//        }

        for (int i = 0; i < n -1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {// 如果i==minIndex的话就说明最先预选的值就是当前轮的最小值,就不用交换了
                temp = nums[i];
                nums[i] = min;
                nums[minIndex] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 2, 3, 1, 2};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
