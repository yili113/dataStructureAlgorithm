package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-12 20:33
 * 选择排序  每次选最小的数放在前面
 */
public class SelectSort1 {
    public static void main(String[] args) {
        int[] arr = {542, 3, 53, 214, 14, 22};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int n =  arr.length;
//        // 第一轮
//        int minVal = arr[0];
//        int minIdx = 0;
//        for (int i = 1; i < n; i++) {
//            if (arr[i] < minVal) {
//                minIdx = i;
//                minVal = arr[minIdx];
//            }
//        }
//        if (0 != minIdx) {
//            swap(arr, 0, minIdx);
//        }
        // n - 1轮
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            int minVal = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minVal) {
                    minIdx = j;
                    minVal = arr[minIdx];
                }
            }
            if (i != minIdx) {// 优化
                swap(arr, i, minIdx);
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
